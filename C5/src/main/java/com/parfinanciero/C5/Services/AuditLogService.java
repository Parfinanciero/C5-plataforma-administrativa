package com.parfinanciero.C5.Services;



import com.parfinanciero.C5.Models.AuditLog;
import com.parfinanciero.C5.Repositories.AuditLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void registerAction(String action, String username, String details) {
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setUsername(username);
        log.setDetails(details);
        auditLogRepository.save(log);
    }
}

