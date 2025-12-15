package com.yourpackage.model;

import jakarta.persistence.*; // Use javax.persistence if using Spring Boot 2.x

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments ID in MySQL
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "department")
    private String department;

    @Column(name = "mobile_number")
    private String mobileNumber;

    // --- Constructors ---

    // Default Constructor (Required by JPA)
    public Faculty() {
    }

    // Parameterized Constructor (For easy object creation)
    public Faculty(String fullName, String email, String password, String department, String mobileNumber) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.department = department;
        this.mobileNumber = mobileNumber;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // --- toString() Method (Optional, for debugging) ---
    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}