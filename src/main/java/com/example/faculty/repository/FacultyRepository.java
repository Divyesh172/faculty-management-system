package com.example.faculty.repository;

import com.example.faculty.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    
    // Used for Login
    Faculty findByEmailAndPassword(String email, String password);

    // Used for Search (The new part)
    List<Faculty> findByFullNameContainingIgnoreCase(String keyword);
}