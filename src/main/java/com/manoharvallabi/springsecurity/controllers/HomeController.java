package com.manoharvallabi.springsecurity.controllers;

import com.manoharvallabi.springsecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greet()
    {
        return "Hello World";
    }

    @GetMapping("/csrf-token")
    public String getCSRFToken(HttpServletRequest request)
    {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        return csrfToken.getToken();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return student;
    }


}
