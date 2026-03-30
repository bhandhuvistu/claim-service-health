cat > src/main/java/com/example/health/dto/HealthResponse.java << 'EOF'
package com.example.health.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthResponse {
    private String status;
    private LocalDateTime timestamp;
    private String message;
    private Map<String, Object> details;

    public HealthResponse() {}

    public HealthResponse(String status, LocalDateTime timestamp, String message, Map<String, Object> details) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public static HealthResponseBuilder builder() {
        return new HealthResponseBuilder();
    }

    public static class HealthResponseBuilder {
        private String status;
        private LocalDateTime timestamp;
        private String message;
        private Map<String, Object> details;

        public HealthResponseBuilder status(String status) {
            this.status = status;
            return this;
        }

        public HealthResponseBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public HealthResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public HealthResponseBuilder details(Map<String, Object> details) {
            this.details = details;
            return this;
        }

        public HealthResponse build() {
            return new HealthResponse(status, timestamp, message, details);
        }
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Map<String, Object> getDetails() { return details; }
    public void setDetails(Map<String, Object> details) { this.details = details; }
}
EOF
