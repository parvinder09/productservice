package com.capstone.productservice.jpaexamples.mappedclasses;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_Instructor")
public class Instructor extends User{
    private String specialization;
}
