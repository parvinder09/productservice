package com.capstone.productservice.jpaexamples.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mentor extends User{
    private double avgRating;
}
