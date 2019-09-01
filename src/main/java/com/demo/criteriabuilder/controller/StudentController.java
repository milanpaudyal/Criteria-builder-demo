package com.demo.criteriabuilder.controller;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/

import com.demo.criteriabuilder.resource.StudentDTO;
import com.demo.criteriabuilder.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StudentController {

    private static final String DATE_PATTERN = "yyyy/MM/dd";
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<StudentDTO> getStudents(@RequestParam(required = false)
                                        @DateTimeFormat(pattern = DATE_PATTERN) Date fromDate,
                                        @RequestParam(required = false)
                                        @DateTimeFormat(pattern = DATE_PATTERN) Date toDate,
                                        @RequestParam(required = false) String name,
                                        Pageable pageable){
        return studentService.getStudents(fromDate, toDate, name, pageable);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody StudentDTO student) {
        studentService.addStudent(student);
    }

}
