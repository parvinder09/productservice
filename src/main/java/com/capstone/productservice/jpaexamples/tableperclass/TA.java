package com.capstone.productservice.jpaexamples.tableperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_TA")
public class TA extends User {
    private int noOfSessions;
    private double avgRating;
}
