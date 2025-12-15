package com.example.faculty.model;

public class VisitingFaculty extends Faculty {
    private int hoursPerWeek;
    private double hourlyRate;
    private String specialization;
    
    public VisitingFaculty() {}
    
    public VisitingFaculty(String id, String name, String department, String email, 
                          String qualification, int hoursPerWeek, double hourlyRate, 
                          String specialization) {
        super(id, name, department, email, qualification);
        this.hoursPerWeek = hoursPerWeek;
        this.hourlyRate = hourlyRate;
        this.specialization = specialization;
    }
    
    @Override
    public String getFacultyType() {
        return "Visiting Faculty";
    }
    
    @Override
    public double calculateSalary() {
        // Visiting faculty paid per hour for 4 weeks in a month
        return hoursPerWeek * hourlyRate * 4;
    }
    
    // Getters and Setters
    public int getHoursPerWeek() { return hoursPerWeek; }
    public void setHoursPerWeek(int hoursPerWeek) { this.hoursPerWeek = hoursPerWeek; }
    
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
}