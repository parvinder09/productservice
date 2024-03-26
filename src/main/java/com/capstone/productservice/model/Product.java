package com.capstone.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    long id;
    String title;
    String description;
    double price;
   String image;
   Category category;

}
