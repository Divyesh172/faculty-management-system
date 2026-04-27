package com.example.faculty.repository;

import com.example.faculty.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    
    Faculty findByEmail(String email);
    List<Faculty> findByFullNameContainingIgnoreCase(String keyword);
}
