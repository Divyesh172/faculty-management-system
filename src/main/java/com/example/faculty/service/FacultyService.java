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
    
    public void updateFaculty(Faculty updatedFaculty) {
        Faculty existingUser = facultyRepository.findById(updatedFaculty.getId()).orElse(null);
        
        if (existingUser != null) {
            existingUser.setFullName(updatedFaculty.getFullName());
            existingUser.setDepartment(updatedFaculty.getDepartment());
            existingUser.setMobileNumber(updatedFaculty.getMobileNumber());
            facultyRepository.save(existingUser);
        }
    }
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public List<Faculty> searchFaculty(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return facultyRepository.findByFullNameContainingIgnoreCase(keyword);
        }
        return facultyRepository.findAll();
    }
}