package com.capstone.productservice.jpaexamples.tableperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "tpc_User")
public class User {
    @Id
    private long Id;
    private String name;
    private String email;
    private String password;
}
