package com.capstone.productservice.controller;

import com.capstone.productservice.exceptions.InvalidProductException;
import com.capstone.productservice.model.Product;
import com.capstone.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws InvalidProductException {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("{id}")
    public ResponseEntity addProduct(@PathVariable("id") long id, @RequestBody Product product){
        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public Product replaceProduct(@PathVariable("id") long id, @RequestBody Product product){
        return productService.replaceProduct(product, id);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") long id){
        return;
    }
}
