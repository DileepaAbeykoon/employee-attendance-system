package com.example.demo.util;

import com.example.demo.entity.Attendance;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfReportGenerator {

    public static ByteArrayInputStream generateAttendanceReport(List<Attendance> attendances) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Employee Attendance Report")
                .setBold()
                .setFontSize(16));

        Table table = new Table(UnitValue.createPercentArray(new float[]{2, 4, 4, 4, 4}));
        table.setWidth(UnitValue.createPercentValue(100));

        table.addHeaderCell("ID");
        table.addHeaderCell("Employee Name");
        table.addHeaderCell("Department");
        table.addHeaderCell("Time In");
        table.addHeaderCell("Time Out");

        for (Attendance a : attendances) {
            table.addCell(a.getId().toString());
            table.addCell(a.getEmployee().getName());
            table.addCell(a.getEmployee().getDepartment());
            table.addCell(a.getTimeIn().toString());
            table.addCell(a.getTimeOut().toString());
        }

        document.add(table);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
