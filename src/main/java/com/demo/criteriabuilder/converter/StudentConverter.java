package com.demo.criteriabuilder.converter;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/

import com.demo.criteriabuilder.domain.Students;
import com.demo.criteriabuilder.resource.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentConverter {

    public static List<StudentDTO> convertToStudentDTO(List<Students> students) {
        return students.stream().map(s ->
                StudentDTO.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .createdDate(s.getCreatedDate())
                        .build()
        ).collect(Collectors.toList());
    }

   public static Students convertToStudent(StudentDTO studentDTO) {
        Students students = new Students();
        students.setName(studentDTO.getName());
        students.setCreatedDate(studentDTO.getCreatedDate());
        return students;
    }

}
