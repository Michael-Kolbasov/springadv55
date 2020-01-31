package com.epam.kolbasov.springadv.util.excel.reader

import com.epam.kolbasov.springadv.util.excel.parser.ExcelParser
import com.epam.kolbasov.springadv.exception.RegistrationException
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory

class ExcelReader implements IExcelReader, AutoCloseable {
    private static final String COMPANY_NAME_HEADER_TEXT = 'Company name'

    InputStream inputStream

    def cache = []
    def parser = new ExcelParser()

    ExcelReader(InputStream inputStream) {
        this.inputStream = inputStream
    }

    @Override
    void readFile() {
        def workbook = WorkbookFactory.create(inputStream)
        def sheet = workbook.getSheetAt 0
        def iterator = sheet.iterator()
        skipToRow(COMPANY_NAME_HEADER_TEXT, iterator)
        doReadFile(iterator)
    }

    private void doReadFile(Iterator<Row> iterator) {
        while (iterator.hasNext()) {
            def row = iterator.next()
            if (parser.isParsable(row)) {
                cache << parser.parse(row)
            }
        }
    }

    private static def skipToRow(String text, Iterator<Row> iterator) {
        while (iterator.hasNext()) {
            def value = iterator.next().getCell(0).getStringCellValue()
            if (value == text) {
                return
            }
        }
        throw new RegistrationException('Incorrect registration template')
    }

    @Override
    void close() throws Exception {
        inputStream.close()
    }
}
