package com.capstone.productservice.jpaexamples.mappedclasses;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_TA")
public class TA extends User{
    private int noOfSessions;
    private double avgRating;
}
