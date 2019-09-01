package com.demo.criteriabuilder.domain;

/*
 @author Milan Paudyal
 @since 9/1/19, Sun
*/


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }

}
