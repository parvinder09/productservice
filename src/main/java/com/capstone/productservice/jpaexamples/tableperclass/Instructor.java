package com.capstone.productservice.jpaexamples.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Instructor")
public class Instructor extends User {
    private String specialization;
}
