package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import com.example.faculty.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Faculty registerFaculty(Faculty faculty) {
        faculty.setPassword(passwordEncoder.encode(faculty.getPassword()));
        return facultyRepository.save(faculty);
    }

    public Faculty authenticate(String email, String rawPassword) {
        Faculty faculty = facultyRepository.findByEmail(email);
        if (faculty != null && passwordEncoder.matches(rawPassword, faculty.getPassword())) {
            return faculty;
        }
        return null;
    }

    public List<Faculty> searchFaculty(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return facultyRepository.findByFullNameContainingIgnoreCase(keyword);
        }
        return facultyRepository.findAll();
    }
}
