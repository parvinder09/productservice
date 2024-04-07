package com.capstone.productservice.jpaexamples.mappedclasses;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;
}
