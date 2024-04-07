package com.capstone.productservice.service;

import com.capstone.productservice.exceptions.InvalidProductException;
import com.capstone.productservice.model.Product;
import com.capstone.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) throws InvalidProductException {
        Optional<Product> productRepositoryById = productRepository.findById(id);
        return productRepositoryById.orElseThrow(() -> new InvalidProductException("Product not found"));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Product product, long id) {
        return null;
    }
}
