cat > src/main/java/com/example/health/controller/HealthController.java << 'EOF'
package com.example.health.controller;

import com.example.health.dto.HealthResponse;
import com.example.health.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = "*")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping
    public ResponseEntity<HealthResponse> getHealth() {
        return ResponseEntity.ok(healthService.getOverallHealth());
    }

    @GetMapping("/detailed")
    public ResponseEntity<HealthResponse> getDetailedHealth() {
        return ResponseEntity.ok(healthService.getDetailedHealth());
    }

    @GetMapping("/claims-service")
    public ResponseEntity<Map<String, Object>> getClaimsServiceHealth() {
        return ResponseEntity.ok(healthService.checkClaimsServiceHealth());
    }

    @GetMapping("/database")
    public ResponseEntity<Map<String, Object>> getDatabaseHealth() {
        return ResponseEntity.ok(healthService.checkDatabaseHealth());
    }

    @GetMapping("/ready")
    public ResponseEntity<Map<String, Object>> getReadiness() {
        Map<String, Object> response = new HashMap<>();
        response.put("ready", true);
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/live")
    public ResponseEntity<Map<String, Object>> getLiveness() {
        Map<String, Object> response = new HashMap<>();
        response.put("live", true);
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
EOF
