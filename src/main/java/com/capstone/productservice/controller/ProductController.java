package com.capstone.productservice.controller;

import com.capstone.productservice.exceptions.InvalidProductException;
import com.capstone.productservice.exceptions.ProductControllerSpecificException;
import com.capstone.productservice.model.Product;
import com.capstone.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
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
    }

    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<String> handleProductControllerSpecificException(ProductControllerSpecificException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
