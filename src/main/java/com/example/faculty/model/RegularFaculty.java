package com.example.faculty.model;

public class RegularFaculty extends Faculty {
    private double basicSalary;
    private int yearsOfExperience;
    private String designation;
    
    public RegularFaculty() {}
    
    public RegularFaculty(String id, String name, String department, String email, 
                         String qualification, double basicSalary, int yearsOfExperience, 
                         String designation) {
        super(id, name, department, email, qualification);
        this.basicSalary = basicSalary;
        this.yearsOfExperience = yearsOfExperience;
        this.designation = designation;
    }
    
    @Override
    public String getFacultyType() {
        return "Regular Faculty";
    }
    
    @Override
    public double calculateSalary() {
        // Regular faculty gets full salary with experience bonus
        double experienceBonus = yearsOfExperience * 1000;
        return basicSalary + experienceBonus;
    }
    
    // Getters and Setters
    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { 
        this.yearsOfExperience = yearsOfExperience; 
    }
    
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}