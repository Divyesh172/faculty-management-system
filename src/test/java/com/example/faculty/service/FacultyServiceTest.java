package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import com.example.faculty.repository.FacultyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    @Mock
    private FacultyRepository facultyRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private FacultyService facultyService;

    private Faculty mockFaculty;

    @BeforeEach
    void setUp() {
        mockFaculty = new Faculty();
        mockFaculty.setId(1L);
        mockFaculty.setEmail("test@ves.ac.in");
        mockFaculty.setPassword("hashedPassword");
    }

    @Test
    void testRegisterFaculty_Success() {
        // Arrange: Tell the mocks how to behave
        when(passwordEncoder.encode(anyString())).thenReturn("hashedPassword");
        when(facultyRepository.save(any(Faculty.class))).thenReturn(mockFaculty);

        Faculty newFaculty = new Faculty();
        newFaculty.setPassword("rawPassword");

        // Act
        Faculty savedFaculty = facultyService.registerFaculty(newFaculty);

        // Assert
        assertNotNull(savedFaculty);
        assertEquals("hashedPassword", savedFaculty.getPassword());
        verify(facultyRepository, times(1)).save(any(Faculty.class));
    }

    @Test
    void testAuthenticate_Success() {
        when(facultyRepository.findByEmail("test@ves.ac.in")).thenReturn(mockFaculty);
        when(passwordEncoder.matches("rawPassword", "hashedPassword")).thenReturn(true);

        Faculty result = facultyService.authenticate("test@ves.ac.in", "rawPassword");

        assertNotNull(result);
        assertEquals("test@ves.ac.in", result.getEmail());
    }

    @Test
    void testAuthenticate_Failure_WrongPassword() {
        when(facultyRepository.findByEmail("test@ves.ac.in")).thenReturn(mockFaculty);
        when(passwordEncoder.matches("wrongPassword", "hashedPassword")).thenReturn(false);

        Faculty result = facultyService.authenticate("test@ves.ac.in", "wrongPassword");

        assertNull(result);
    }
}
