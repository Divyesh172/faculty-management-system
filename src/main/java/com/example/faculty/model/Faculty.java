package com.example.faculty.model;

public abstract class Faculty {
    private String id;
    private String name;
    private String department;
    private String email;
    private String qualification;
    
    public Faculty() {}
    
    public Faculty(String id, String name, String department, String email, String qualification) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.qualification = qualification;
    }
    
    // Abstract method to get faculty type
    public abstract String getFacultyType();
    
    // Abstract method to calculate salary
    public abstract double calculateSalary();
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    
    @Override
    public String toString() {
        return "Faculty{id='" + id + "', name='" + name + 
               "', department='" + department + "', type='" + getFacultyType() + "'}";
    }
}