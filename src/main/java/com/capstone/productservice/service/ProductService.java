package com.capstone.productservice.service;

import com.capstone.productservice.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(long id);
    public Product saveProduct(Product product);
    public void deleteProduct(long id);
    public Product updateProduct(Product product);
    Product replaceProduct(Product product, long id);

}
