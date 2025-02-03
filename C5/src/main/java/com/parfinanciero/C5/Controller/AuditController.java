package com.parfinanciero.C5.Controller;



import com.parfinanciero.C5.Services.AuditPdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auditoria")
public class AuditController {

    private final AuditPdfService auditPdfService;

    public AuditController(AuditPdfService auditPdfService) {
        this.auditPdfService = auditPdfService;
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> descargarPdf() {
        byte[] pdfContent = auditPdfService.generarPdfAuditoria();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=auditoria.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfContent);
    }
}
