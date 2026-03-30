package com.example.health;

import com.example.health.controller.HealthController;
import com.example.health.service.HealthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HealthService healthService;

    @Test
    void testGetHealth() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetDetailedHealth() throws Exception {
        mockMvc.perform(get("/api/health/detailed"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetClaimsServiceHealth() throws Exception {
        mockMvc.perform(get("/api/health/claims-service"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetDatabaseHealth() throws Exception {
        mockMvc.perform(get("/api/health/database"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetReadiness() throws Exception {
        mockMvc.perform(get("/api/health/ready"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetLiveness() throws Exception {
        mockMvc.perform(get("/api/health/live"))
                .andExpect(status().isOk());
    }
}
