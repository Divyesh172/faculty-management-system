package com.example.faculty.repository;

import com.example.faculty.model.Faculty;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FacultyRepository {
    // Demonstrating DI - This component will be autowired into service
    private final Map<String, Faculty> facultyDatabase = new ConcurrentHashMap<>();
    
    public FacultyRepository() {
        System.out.println("FacultyRepository bean created - Dependency Injection in action!");
    }
    
    public Faculty save(Faculty faculty) {
        facultyDatabase.put(faculty.getId(), faculty);
        return faculty;
    }
    
    public Optional<Faculty> findById(String id) {
        return Optional.ofNullable(facultyDatabase.get(id));
    }
    
    public List<Faculty> findAll() {
        return new ArrayList<>(facultyDatabase.values());
    }
    
    public void deleteById(String id) {
        facultyDatabase.remove(id);
    }
    
    public boolean existsById(String id) {
        return facultyDatabase.containsKey(id);
    }
}