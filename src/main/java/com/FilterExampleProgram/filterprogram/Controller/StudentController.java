package com.FilterExampleProgram.filterprogram.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("info")
    public String getStudentInfo(){
        return "Student information accessed!" ;
    }

    @GetMapping("/profile")
    public String getStudentProfile(){
        return "Student profile accessed!";
    }
}
