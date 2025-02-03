package com.parfinanciero.C5.Controller;

import com.parfinanciero.C5.Services.ApiService;
import com.parfinanciero.C5.Services.AuditLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final AuditLogService auditLogService;


    private final ApiService apiService;

    public ApiController(AuditLogService auditLogService, ApiService apiService) {
        this.auditLogService = auditLogService;
        this.apiService = apiService;
    }

    @GetMapping("/test")
    public String testAuditoria() {
        auditLogService.registerAction("TEST_ACTION", "admin", "Probando la auditoría");
        return "Registro de auditoría guardado.";
    }

    @GetMapping("/goals")
    public Object getGoals() {
        return apiService.getAllGoals();
    }

    @GetMapping("/bills")
    public Object getBills() {
        return apiService.getAllBills();
    }

    @GetMapping("/users/{id}")
    public Object getUser(@PathVariable Long id) {
        return apiService.getUser(id);
    }
}