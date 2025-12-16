package com.example.faculty.controller;

import com.example.faculty.model.Faculty; 
import com.example.faculty.service.FacultyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerFaculty(@ModelAttribute Faculty faculty) {
        facultyService.registerFaculty(faculty);
        return "redirect:/faculty/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginFaculty(@RequestParam String email, 
                               @RequestParam String password, 
                               Model model, 
                               HttpSession session) {
        Faculty faculty = facultyService.loginFaculty(email, password);
        if (faculty != null) {
            session.setAttribute("loggedInUser", faculty);
            return "redirect:/faculty/dashboard";
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/faculty/login";
        }
        return "dashboard";
    }
    
    @PostMapping("/register")
    public String registerFaculty(@ModelAttribute Faculty faculty, RedirectAttributes redirectAttributes) {
    facultyService.registerFaculty(faculty);

    redirectAttributes.addFlashAttribute("message", "Registration Successful! Please Login.");
    redirectAttributes.addFlashAttribute("messageType", "success");

    return "redirect:/faculty/login";
 }

    @GetMapping("/all")
    public String getAllFaculty(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Faculty> list = facultyService.searchFaculty(keyword);
        model.addAttribute("facultyList", list);
        model.addAttribute("keyword", keyword); // Send keyword back so it stays in the search box
        return "faculty-list";
    }
}