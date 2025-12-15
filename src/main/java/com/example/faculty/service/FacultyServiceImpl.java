package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import com.example.faculty.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty registerFaculty(Faculty faculty) {
        if (facultyRepository.existsByEmail(faculty.getEmail())) {
            throw new RuntimeException("Faculty with this email already exists!");
        }
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty loginFaculty(String email, String password) {
        Optional<Faculty> facultyOpt = facultyRepository.findByEmail(email);
        if (facultyOpt.isPresent()) {
            Faculty faculty = facultyOpt.get();
            if (faculty.getPassword().equals(password)) {
                return faculty;
            }
        }
        return null;
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
}