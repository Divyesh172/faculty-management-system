package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import com.example.faculty.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    
    // Demonstrating Constructor-based Dependency Injection
    private final FacultyRepository facultyRepository;
    
    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
        System.out.println("FacultyServiceImpl bean created with autowired FacultyRepository!");
    }
    
    @Override
    public Faculty addFaculty(Faculty faculty) {
        if (facultyRepository.existsById(faculty.getId())) {
            throw new RuntimeException("Faculty with ID " + faculty.getId() + " already exists!");
        }
        return facultyRepository.save(faculty);
    }
    
    @Override
    public Faculty getFacultyById(String id) {
        return facultyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Faculty not found with ID: " + id));
    }
    
    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
    
    @Override
    public void deleteFaculty(String id) {
        if (!facultyRepository.existsById(id)) {
            throw new RuntimeException("Faculty not found with ID: " + id);
        }
        facultyRepository.deleteById(id);
    }
    
    @Override
    public long getTotalFacultyCount() {
        return facultyRepository.findAll().size();
    }
    
    @Override
    public double getTotalSalaryExpenditure() {
        return facultyRepository.findAll().stream()
            .mapToDouble(Faculty::calculateSalary)
            .sum();
    }
}
