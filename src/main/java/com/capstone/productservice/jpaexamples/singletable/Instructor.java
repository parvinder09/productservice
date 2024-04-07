package com.capstone.productservice.jpaexamples.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Instructor extends User{
    private String specialization;
}
