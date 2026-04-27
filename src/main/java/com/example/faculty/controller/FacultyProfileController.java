package com.example.faculty.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.faculty.model.Faculty;
import com.example.faculty.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/faculty")
public class FacultyProfileController {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentProfile() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Faculty faculty = facultyRepository.findByEmail(email);
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> getAllFaculty(@RequestParam(required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return ResponseEntity.ok(facultyRepository.findByFullNameContainingIgnoreCase(keyword));
        }
        return ResponseEntity.ok(facultyRepository.findAll());
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(
            @RequestParam("fullName") String fullName,
            @RequestParam("department") String department,
            @RequestParam("mobileNumber") String mobileNumber,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Faculty existingUser = facultyRepository.findByEmail(email);

        existingUser.setFullName(fullName);
        existingUser.setDepartment(department);
        existingUser.setMobileNumber(mobileNumber);

        if (file != null && !file.isEmpty()) {
            try {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = uploadResult.get("secure_url").toString();
                existingUser.setProfileImageUrl(imageUrl);
            } catch (IOException e) {
                return ResponseEntity.status(500).body(Map.of("error", "Image upload failed"));
            }
        }

        facultyRepository.save(existingUser);
        return ResponseEntity.ok(Map.of("message", "Profile updated successfully", "profileImageUrl", existingUser.getProfileImageUrl()));
    }
}
