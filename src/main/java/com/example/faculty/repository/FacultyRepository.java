package com.yourpackage.repository;

import com.yourpackage.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    // Custom method to find a faculty member by email (useful for Login)
    // Spring Boot automatically generates the SQL for this based on the method name.
    Optional<Faculty> findByEmail(String email);

    // Optional: Check if an email already exists before registering
    boolean existsByEmail(String email);
}