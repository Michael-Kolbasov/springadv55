package com.epam.kolbasov.springadv.util.excel.parser

import org.apache.poi.ss.usermodel.Row

interface IExcelParser<T> {
    boolean isParsable(Row row)
    T parse(Row row)
}