package com.demo.criteriabuilder.service;

import com.demo.criteriabuilder.resource.StudentDTO;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/

public interface StudentService {

    void addStudent(StudentDTO student);

    List<StudentDTO> getStudents(Date fromDate, Date toDate, String name, Pageable pageable);
}
