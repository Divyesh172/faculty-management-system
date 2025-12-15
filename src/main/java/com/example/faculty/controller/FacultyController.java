package com.yourpackage.controller;

import com.yourpackage.model.Faculty;
import com.yourpackage.service.FacultyService;
import jakarta.servlet.http.HttpSession; // Use javax.servlet.http if on older Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // ===========================
    // 1. REGISTRATION
    // ===========================
    
    // Show the Registration Form (GET)
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Loads /WEB-INF/jsp/register.jsp
    }

    // Process the Registration (POST)
    @PostMapping("/register")
    public String registerFaculty(@ModelAttribute Faculty faculty) {
        facultyService.registerFaculty(faculty);
        return "redirect:/faculty/login"; // Redirect to login after successful register
    }

    // ===========================
    // 2. LOGIN
    // ===========================

    // Show the Login Form (GET)
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Loads /WEB-INF/jsp/login.jsp
    }

    // Process the Login (POST)
    // NOTE: We use @RequestParam for Form Data, NOT @RequestBody
    @PostMapping("/login")
    public String loginFaculty(@RequestParam String email, 
                               @RequestParam String password, 
                               Model model, 
                               HttpSession session) {
        
        Faculty faculty = facultyService.loginFaculty(email, password);

        if (faculty != null) {
            // Login Success: Save user in Session and go to Dashboard
            session.setAttribute("loggedInUser", faculty);
            return "redirect:/faculty/dashboard";
        } else {
            // Login Failed: Reload login page with an error message
            model.addAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }

    // ===========================
    // 3. DASHBOARD & LIST
    // ===========================

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        // Security Check: Is user logged in?
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/faculty/login";
        }
        return "dashboard"; // Loads /WEB-INF/jsp/dashboard.jsp
    }

    // Show All Faculty (Admin View)
    @GetMapping("/all")
    public String getAllFaculty(Model model) {
        // Add the list of faculty to the model so the JSP can read it
        model.addAttribute("facultyList", facultyService.getAllFaculty());
        return "faculty-list"; // Loads /WEB-INF/jsp/faculty-list.jsp
    }
}