package com.parfinanciero.C5.Services;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import com.parfinanciero.C5.Models.AuditLog;
import com.parfinanciero.C5.Repositories.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class AuditPdfService {

    private final AuditLogRepository auditLogRepository;

    public AuditPdfService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public byte[] generarPdfAuditoria() {
        List<AuditLog> logs = auditLogRepository.findAll();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Título del documento
        document.add(new Paragraph("Registro de Auditoría")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setFontSize(18));

        // Espaciado
        document.add(new Paragraph("\n"));

        // Crear la tabla
        Table table = new Table(new float[]{1, 2, 3, 2});
        table.setWidth(UnitValue.createPercentValue(100));
        table.addHeaderCell("ID");
        table.addHeaderCell("Acción");
        table.addHeaderCell("Usuario");
        table.addHeaderCell("Fecha");

        // Llenar la tabla con registros de auditoría
        for (AuditLog log : logs) {
            table.addCell(String.valueOf(log.getId()));
            table.addCell(log.getAction());
            table.addCell(log.getUsername());
            table.addCell(log.getTimestamp().toString());
        }

        document.add(table);
        document.close();

        return baos.toByteArray();
    }
}
