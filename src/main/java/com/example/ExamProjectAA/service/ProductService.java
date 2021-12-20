package com.example.ExamProjectAA.service;

import com.example.ExamProjectAA.model.Cart;
import com.example.ExamProjectAA.model.Product;

import java.util.Set;

public interface ProductService {

    Product save(Product product);
    Product findByName(String name);
    Product findById(Long id);
    Product update(Product product, Long id);
    void delete(Long id);
    Set<Product> findAll();
}
