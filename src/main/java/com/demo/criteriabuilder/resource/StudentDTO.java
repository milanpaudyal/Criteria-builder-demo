package com.demo.criteriabuilder.resource;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class StudentDTO {

    private int id;

    private String name;

    private Date createdDate;

}
