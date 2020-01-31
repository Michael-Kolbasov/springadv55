package com.epam.kolbasov.springadv.util.pdf

import com.epam.kolbasov.springadv.exception.PdfGenerationException
import com.epam.kolbasov.springadv.model.Telephone
import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Element
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter

class PdfReportGenerator implements IReportGenerator {

    @Override
    ByteArrayInputStream generate(Collection<?> collection) {
        def document = new Document()
        def out = new ByteArrayOutputStream()

        try {
            def table = new PdfPTable(3)
            table.setWidthPercentage(60)
            table.setWidths([1, 2, 4] as float[])

            def headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD)

            def hcell = new PdfPCell(new Phrase("Id", headFont))
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER)
            table.addCell(hcell)

            hcell = new PdfPCell(new Phrase("Name", headFont))
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER)
            table.addCell(hcell)

            hcell = new PdfPCell(new Phrase("Telephones", headFont))
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER)
            table.addCell(hcell)

            for (element in collection) {
                PdfPCell cell = new PdfPCell(new Phrase(element.id as String))
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                cell.setHorizontalAlignment(Element.ALIGN_CENTER)
                table.addCell(cell)

                cell = new PdfPCell(new Phrase(element.name))
                cell.setPaddingLeft(5)
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                cell.setHorizontalAlignment(Element.ALIGN_LEFT)
                table.addCell(cell)

                cell = new PdfPCell(new Phrase(element.telephones as String))
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT)
                cell.setPaddingRight(5)
                table.addCell(cell)
            }

            PdfWriter.getInstance(document, out)
            document.open()
            document.add(table)

            document.close()
            new ByteArrayInputStream(out.toByteArray())
        } catch (DocumentException e) {
            throw new PdfGenerationException("Report generation error.", e)
        }
    }
}
