package com.example.faculty.model;

public class AdhocFaculty extends Faculty {
    private int numberOfClasses;
    private double payPerClass;
    private String contractDuration;
    
    public AdhocFaculty() {}
    
    public AdhocFaculty(String id, String name, String department, String email, 
                       String qualification, int numberOfClasses, double payPerClass, 
                       String contractDuration) {
        super(id, name, department, email, qualification);
        this.numberOfClasses = numberOfClasses;
        this.payPerClass = payPerClass;
        this.contractDuration = contractDuration;
    }
    
    @Override
    public String getFacultyType() {
        return "Adhoc Faculty";
    }
    
    @Override
    public double calculateSalary() {
        // Adhoc faculty paid per class
        return numberOfClasses * payPerClass;
    }
    
    // Getters and Setters
    public int getNumberOfClasses() { return numberOfClasses; }
    public void setNumberOfClasses(int numberOfClasses) { 
        this.numberOfClasses = numberOfClasses; 
    }
    
    public double getPayPerClass() { return payPerClass; }
    public void setPayPerClass(double payPerClass) { this.payPerClass = payPerClass; }
    
    public String getContractDuration() { return contractDuration; }
    public void setContractDuration(String contractDuration) { 
        this.contractDuration = contractDuration; 
    }
}