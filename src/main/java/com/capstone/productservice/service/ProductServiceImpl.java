package com.capstone.productservice.service;

import com.capstone.productservice.configs.RestTemplateBean;
import com.capstone.productservice.dto.ProductDTO;
import com.capstone.productservice.exceptions.InvalidProductException;
import com.capstone.productservice.model.Category;
import com.capstone.productservice.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    RestTemplateBean restTemplate;

    public ProductServiceImpl(RestTemplateBean restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        /*ProductDTO[] forObject = restTemplate.getRestTemplate().getForObject("https://fakestoreapi.com/products", ProductDTO[].class);*//**//*
        return List.of(forObject).stream().map(this::convertProductDTOToProduct).toList();*/
        ResponseEntity<ProductDTO[]> responseEntity = restTemplate.getRestTemplate().exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        ProductDTO[] productDTOs = responseEntity.getBody();
        HttpHeaders headers = responseEntity.getHeaders();
        HttpStatusCode statusCode = responseEntity.getStatusCode();
        return Arrays.asList(productDTOs).stream().map(this::convertProductDTOToProduct).toList();
    }

    @Override
    public Product getProductById(long id) throws InvalidProductException {
        ProductDTO productDTO = restTemplate.getRestTemplate().getForObject("https://fakestoreapi.com/products/"+id, ProductDTO.class);
        if(productDTO == null){
            throw new InvalidProductException("Product not found");
        }
        return convertProductDTOToProduct(productDTO);
    }

    @Override
    public Product replaceProduct(Product product, long id) {
        RequestCallback requestCallback = restTemplate.getRestTemplate().httpEntityCallback(product, ProductDTO.class);
        ResponseExtractor<ResponseEntity<ProductDTO>> responseExtractor =
                restTemplate.getRestTemplate().responseEntityExtractor(ProductDTO.class);
        ResponseEntity<ProductDTO> fakeStoreProductDto = restTemplate.getRestTemplate().execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT,
                requestCallback, responseExtractor);
        return convertProductDTOToProduct(fakeStoreProductDto.getBody());
    }
    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    private Product convertProductDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setCategory(new Category(1, productDTO.getCategory()));
        return product;
    }
}
