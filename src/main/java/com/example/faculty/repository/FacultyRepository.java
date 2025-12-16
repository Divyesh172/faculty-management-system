package com.example.faculty.repository;

import com.example.faculty.model.Faculty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Faculty> findByFullNameContainingIgnoreCase(String keyword);
}