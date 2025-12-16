package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import java.util.List;

public interface FacultyService {
    Faculty registerFaculty(Faculty faculty);
    Faculty loginFaculty(String email, String password);
    List<Faculty> getAllFaculty();
    Faculty getFacultyById(Long id);
}

public List<Faculty> searchFaculty(String keyword) {
    if (keyword != null && !keyword.isEmpty()) {
        return facultyRepository.findByFullNameContainingIgnoreCase(keyword);
    }
    return facultyRepository.findAll();
}