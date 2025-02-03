package com.parfinanciero.C5.Services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

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
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Título del documento
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Registro de Auditoría", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Espaciado
            document.add(new Paragraph("\n"));

            // Crear la tabla
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 3, 2});

            // Encabezados de la tabla
            addTableHeader(table, "ID");
            addTableHeader(table, "Acción");
            addTableHeader(table, "Usuario");
            addTableHeader(table, "Fecha");

            // Llenar la tabla con registros de auditoría
            for (AuditLog log : logs) {
                table.addCell(String.valueOf(log.getId()));
                table.addCell(log.getAction());
                table.addCell(log.getUsername());
                table.addCell(log.getTimestamp().toString());
            }

            document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return baos.toByteArray();
    }

    private void addTableHeader(PdfPTable table, String columnTitle) {
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        PdfPCell header = new PdfPCell(new Phrase(columnTitle, headerFont));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.setBackgroundColor(new GrayColor(0.75f));
        table.addCell(header);
    }
}
