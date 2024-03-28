package com.capstone.productservice.service;

import com.capstone.productservice.exceptions.InvalidProductException;
import com.capstone.productservice.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(long id) throws InvalidProductException;
    Product saveProduct(Product product);
    void deleteProduct(long id);
    Product updateProduct(Product product);
    Product replaceProduct(Product product, long id);

}
