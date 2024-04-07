package com.capstone.productservice.repository;

import com.capstone.productservice.model.Category;
import com.capstone.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Optional<Product> findByTitleAndDescription(String title,
                                                String description);

    List<Product> findByTitleContaining(String word);
    //Using like operator.

    List<Product> findTopThreeByTitle(String title); // limit the result by 3

    Optional<Product> findByCategory(Category category);

    void deleteById(Long id);

    void deleteByTitle(String title);

    Product save(Product product);

}
