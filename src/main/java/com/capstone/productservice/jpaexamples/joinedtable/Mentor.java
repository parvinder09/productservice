package com.capstone.productservice.jpaexamples.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_Mentor")
public class Mentor extends User{
    private double avgRating;
}
