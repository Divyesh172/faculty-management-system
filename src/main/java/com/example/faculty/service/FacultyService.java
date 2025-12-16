package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import com.example.faculty.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public void registerFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public Faculty loginFaculty(String email, String password) {
        return facultyRepository.findByEmailAndPassword(email, password);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    // The Search Method
    public List<Faculty> searchFaculty(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return facultyRepository.findByFullNameContainingIgnoreCase(keyword);
        }
        return facultyRepository.findAll();
    }
}