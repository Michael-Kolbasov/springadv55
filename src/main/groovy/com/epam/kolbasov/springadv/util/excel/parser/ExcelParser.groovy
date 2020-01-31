package com.epam.kolbasov.springadv.util.excel.parser

import com.epam.kolbasov.springadv.model.Telephone
import com.epam.kolbasov.springadv.model.TelephoneCompany
import com.epam.kolbasov.springadv.model.User
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.springframework.util.StringUtils

class ExcelParser implements IExcelParser<Tuple3<TelephoneCompany, Telephone, User>> {

    private static final int COMPANY_COLUMN = 0
    private static final int TELEPHONE_COLUMN = 1
    private static final int USER_COLUMN = 2

    def formatter = new DataFormatter()

    @Override
    boolean isParsable(Row row) {
        def company = formatter.formatCellValue(row.getCell(COMPANY_COLUMN))
        def number = formatter.formatCellValue(row.getCell(TELEPHONE_COLUMN))
        !StringUtils.isEmpty(company) && !StringUtils.isEmpty(number)
    }

    @Override
    Tuple3<TelephoneCompany, Telephone, User> parse(Row row) {
        def companyName = formatter.formatCellValue(row.getCell(COMPANY_COLUMN))
        def company = new TelephoneCompany(name: companyName)

        def number = formatter.formatCellValue(row.getCell(TELEPHONE_COLUMN))
        def telephone = new Telephone(number: number, free: true)
        company.telephones << telephone

        def userId = formatter.formatCellValue(row.getCell(USER_COLUMN)) as Long
        def user = null
        if (!StringUtils.isEmpty(userId)) {
            user = new User(id: userId)
            user.telephones << telephone
            telephone.free = false
        }

        new Tuple3<TelephoneCompany, Telephone, User>(company, telephone, user)
    }
}
