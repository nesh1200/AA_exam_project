package com.example.ExamProjectAA.service.Impl;

import com.example.ExamProjectAA.model.Product;
import com.example.ExamProjectAA.repository.ProductRepository;
import com.example.ExamProjectAA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product update(Product product, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<Product> findAll() {
        return null;
    }
}
