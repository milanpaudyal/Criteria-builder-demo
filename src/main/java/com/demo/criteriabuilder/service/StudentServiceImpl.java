package com.demo.criteriabuilder.service;

import com.demo.criteriabuilder.converter.StudentConverter;
import com.demo.criteriabuilder.domain.Students;
import com.demo.criteriabuilder.repository.StudentRepository;
import com.demo.criteriabuilder.resource.StudentDTO;
import com.demo.criteriabuilder.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(StudentDTO student) {
        studentRepository.save(StudentConverter.convertToStudent(student));
    }

    @Override
    public List<StudentDTO> getStudents(Date fromDate, Date toDate, String name, Pageable pageable) {
        List<Students> students = studentRepository.findAll((Specification<Students>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
                p = cb.and(p, cb.between(root.get("createdDate"), fromDate, toDate));
            }
            if (!StringUtils.isEmpty(name)) {
                p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
            }
            cq.orderBy(cb.desc(root.get("name")), cb.asc(root.get("id")));
            return p;
        }, pageable).getContent();
        return StudentConverter.convertToStudentDTO(students);
    }
}
