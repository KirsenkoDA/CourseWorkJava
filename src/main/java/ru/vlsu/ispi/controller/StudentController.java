package ru.vlsu.ispi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlsu.ispi.model.Student;
import ru.vlsu.ispi.service.StudentService;

import java.util.List;
@RequestMapping("/students")
@Controller
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/")
    public String index(Model model) {
        List<Student> studentList = studentService.index();
        model.addAttribute("studentList", studentList);
        return "index/index";
    }
}
