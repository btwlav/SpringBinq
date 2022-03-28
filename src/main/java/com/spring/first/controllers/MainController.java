package com.spring.first.controllers;

import com.spring.first.entity.Group;
import com.spring.first.entity.Student;
import com.spring.first.repos.GroupRepo;
import com.spring.first.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private GroupRepo groupRepo;

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }

    @GetMapping("/")
    public String main(@RequestParam(required = false) String fioFilter, Model model) {
        Iterable<Student> students = studentRepo.findAll();
        Iterable<Group> groups = groupRepo.findAll();

        if (fioFilter != null && !fioFilter.isEmpty()) {
            students = studentRepo.findByFioContaining(fioFilter);
        }

        model.addAttribute("students", students);
        model.addAttribute("filter", fioFilter);
        model.addAttribute("groups", groups);
        return "main";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String fio,
                             @RequestParam(value = "groupName") String groupsValue,
                             Map<String, Object> model) {
        if (fio.isEmpty()) {
            fio = "John";
        }

        Student student = new Student(fio, groupRepo.findByNameContaining(groupsValue));
        studentRepo.save(student);

        Iterable<Student> students = studentRepo.findAll();
        Iterable<Group> groups = groupRepo.findAll();
        model.put("students", students);
        model.put("groups", groups);
        return "main";
    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String fioFilter, Map<String, Object> model) {
//        Iterable<Student> students;
//
//        if (!fioFilter.isEmpty()) {
//            students = studentRepo.findByFioContaining(fioFilter);
//        } else {
//            students = studentRepo.findAll();
//        }
//        model.put("students", students);
//        return "main";
//    }
}