package com.example.faculty.controller;

import com.example.faculty.model.*;
import com.example.faculty.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    
    // Demonstrating Field-based Dependency Injection with @Autowired
    @Autowired
    private FacultyService facultyService;
    
    public FacultyController() {
        System.out.println("FacultyController bean created - Service will be autowired!");
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalFaculty", facultyService.getTotalFacultyCount());
        model.addAttribute("totalSalary", facultyService.getTotalSalaryExpenditure());
        return "index";
    }
    
    @GetMapping("/add")
    public String showAddForm() {
        return "add-faculty";
    }
    
    @PostMapping("/add")
    public String addFaculty(@RequestParam String type,
                            @RequestParam String id,
                            @RequestParam String name,
                            @RequestParam String department,
                            @RequestParam String email,
                            @RequestParam String qualification,
                            @RequestParam(required = false) String basicSalary,
                            @RequestParam(required = false) String yearsOfExperience,
                            @RequestParam(required = false) String designation,
                            @RequestParam(required = false) String hoursPerWeek,
                            @RequestParam(required = false) String hourlyRate,
                            @RequestParam(required = false) String specialization,
                            @RequestParam(required = false) String numberOfClasses,
                            @RequestParam(required = false) String payPerClass,
                            @RequestParam(required = false) String contractDuration,
                            Model model) {
        try {
            Faculty faculty = null;
            
            switch (type) {
                case "regular":
                    faculty = new RegularFaculty(id, name, department, email, qualification,
                        Double.parseDouble(basicSalary), Integer.parseInt(yearsOfExperience), designation);
                    break;
                case "visiting":
                    faculty = new VisitingFaculty(id, name, department, email, qualification,
                        Integer.parseInt(hoursPerWeek), Double.parseDouble(hourlyRate), specialization);
                    break;
                case "adhoc":
                    faculty = new AdhocFaculty(id, name, department, email, qualification,
                        Integer.parseInt(numberOfClasses), Double.parseDouble(payPerClass), contractDuration);
                    break;
            }
            
            facultyService.addFaculty(faculty);
            model.addAttribute("message", "Faculty added successfully!");
            model.addAttribute("messageType", "success");
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
            model.addAttribute("messageType", "error");
        }
        
        return "add-faculty";
    }
    
    @GetMapping("/view")
    public String viewAllFaculty(Model model) {
        model.addAttribute("facultyList", facultyService.getAllFaculty());
        return "view-faculty";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable String id, Model model) {
        try {
            facultyService.deleteFaculty(id);
            model.addAttribute("message", "Faculty deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        model.addAttribute("facultyList", facultyService.getAllFaculty());
        return "view-faculty";
    }
}