package ru.zanko.mailsender.service;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import ru.zanko.mailsender.entity.User;


import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


public class PDFConverter {

    public static Document convertToPdf() {

        try {
            List<User> list = JSONConverter.parse();
            PdfWriter pdfWriter = new PdfWriter("newPDF.pdf");
            float[] columnWidth = {200F, 100F, 200F};
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.addNewPage();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Document document = new Document(pdfDocument);
            Paragraph paragraph = new Paragraph("RED TEAM").setFontSize(50F)
                    .setFontColor(Color.RED);
            Paragraph date = new Paragraph(String.valueOf(formatter.format(new Date(System.currentTimeMillis()))))
                    .setFontSize(15F);
            document.add(paragraph).add(date);
            Table table = new Table(columnWidth);
            table.addCell(new Cell().add("User name"));
            table.addCell(new Cell().add("Spend time"));
            table.addCell(new Cell().add("Activities"));

            assert list != null;
            for (User el : list) {
                table.addCell(new Cell().add(el.getUserName()))
                        .addCell(new Cell().add(String.valueOf(el.getTimeToSpend())))
                        .addCell(new Cell().add(el.getActivity()));
            }

            document.add(table);

            document.close();
            return document;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
