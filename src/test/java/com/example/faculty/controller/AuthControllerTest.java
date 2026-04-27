package com.example.faculty.controller;

import com.example.faculty.model.Faculty;
import com.example.faculty.security.JwtUtil;
import com.example.faculty.service.FacultyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testLogin_Success() throws Exception {
        Faculty mockFaculty = new Faculty();
        mockFaculty.setEmail("test@ves.ac.in");
        mockFaculty.setFullName("Test User");

        when(facultyService.authenticate(anyString(), anyString())).thenReturn(mockFaculty);
        when(jwtUtil.generateToken(anyString())).thenReturn("mock.jwt.token");

        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", "test@ves.ac.in");
        credentials.put("password", "password123");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(credentials)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mock.jwt.token"))
                .andExpect(jsonPath("$.email").value("test@ves.ac.in"));
    }

    @Test
    void testLogin_Failure() throws Exception {
        when(facultyService.authenticate(anyString(), anyString())).thenReturn(null);

        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", "wrong@ves.ac.in");
        credentials.put("password", "wrongpass");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(credentials)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error").exists());
    }
}
