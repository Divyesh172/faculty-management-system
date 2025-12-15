package com.example.faculty.service;

import com.example.faculty.model.Faculty;
import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty getFacultyById(String id);
    List<Faculty> getAllFaculty();
    void deleteFaculty(String id);
    long getTotalFacultyCount();
    double getTotalSalaryExpenditure();
}