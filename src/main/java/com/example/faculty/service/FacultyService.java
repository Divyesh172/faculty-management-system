package com.yourpackage.service;

import com.yourpackage.model.Faculty;
import com.yourpackage.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // 1. Register a new Faculty member
    public Faculty registerFaculty(Faculty faculty) {
        // Check if email already exists to prevent duplicates
        if (facultyRepository.existsByEmail(faculty.getEmail())) {
            throw new RuntimeException("Faculty with this email already exists!");
        }
        // Save to database
        return facultyRepository.save(faculty);
    }

    // 2. Login Logic
    public Faculty loginFaculty(String email, String password) {
        Optional<Faculty> facultyOpt = facultyRepository.findByEmail(email);

        if (facultyOpt.isPresent()) {
            Faculty faculty = facultyOpt.get();
            // Check if the password matches
            if (faculty.getPassword().equals(password)) {
                return faculty;
            }
        }
        return null; // Return null if login fails
    }

    // 3. Get All Faculty Members (for Admin dashboard)
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
    
    // 4. Get Single Faculty by ID
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
}