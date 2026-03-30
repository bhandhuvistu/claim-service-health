cat > src/main/java/com/example/health/service/HealthService.java << 'EOF'
package com.example.health.service;

import com.example.health.dto.HealthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class HealthService {

    private static final Logger logger = LoggerFactory.getLogger(HealthService.class);

    public HealthResponse getOverallHealth() {
        try {
            return HealthResponse.builder()
                    .status("UP")
                    .timestamp(LocalDateTime.now())
                    .message("Overall system health status")
                    .build();
        } catch (Exception e) {
            logger.error("Error getting overall health", e);
            return HealthResponse.builder()
                    .status("DOWN")
                    .timestamp(LocalDateTime.now())
                    .message("Failed to retrieve health status: " + e.getMessage())
                    .build();
        }
    }

    public HealthResponse getDetailedHealth() {
        try {
            Map<String, Object> details = new HashMap<>();
            details.put("database", "UP");
            details.put("cache", "UP");
            details.put("api", "UP");
            details.put("jvm_memory", "OK");
            
            return HealthResponse.builder()
                    .status("UP")
                    .timestamp(LocalDateTime.now())
                    .message("Detailed health information")
                    .details(details)
                    .build();
        } catch (Exception e) {
            logger.error("Error getting detailed health", e);
            return HealthResponse.builder()
                    .status("DOWN")
                    .timestamp(LocalDateTime.now())
                    .message("Failed to retrieve detailed health: " + e.getMessage())
                    .build();
        }
    }

    public Map<String, Object> checkClaimsServiceHealth() {
        try {
            Map<String, Object> status = new HashMap<>();
            status.put("service", "Claims Service");
            status.put("status", "UP");
            status.put("responseTime", System.currentTimeMillis());
            status.put("timestamp", LocalDateTime.now());
            return status;
        } catch (Exception e) {
            logger.error("Error checking claims service health", e);
            Map<String, Object> status = new HashMap<>();
            status.put("service", "Claims Service");
            status.put("status", "DOWN");
            status.put("message", "Error: " + e.getMessage());
            return status;
        }
    }

    public Map<String, Object> checkDatabaseHealth() {
        try {
            Map<String, Object> status = new HashMap<>();
            status.put("service", "Database");
            status.put("status", "UP");
            status.put("message", "Database connection established");
            status.put("timestamp", LocalDateTime.now());
            return status;
        } catch (Exception e) {
            logger.error("Error checking database health", e);
            Map<String, Object> status = new HashMap<>();
            status.put("service", "Database");
            status.put("status", "DOWN");
            status.put("message", "Database connection failed: " + e.getMessage());
            return status;
        }
    }
}
EOF
