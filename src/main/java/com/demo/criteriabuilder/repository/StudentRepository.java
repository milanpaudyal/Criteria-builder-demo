package com.demo.criteriabuilder.repository;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/

import com.demo.criteriabuilder.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer>, JpaSpecificationExecutor<Students> {
}
