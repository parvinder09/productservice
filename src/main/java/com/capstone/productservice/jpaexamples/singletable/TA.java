package com.capstone.productservice.jpaexamples.singletable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TA extends User{
    private int noOfSessions;
    private double avgRating;
}
