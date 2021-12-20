package com.example.ExamProjectAA.service.Impl;

import com.example.ExamProjectAA.exception.ResourceNotFoundException;
import com.example.ExamProjectAA.model.Product;
import com.example.ExamProjectAA.repository.ProductRepository;
import com.example.ExamProjectAA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        return productRepository.findByName(name).orElseThrow(()-> new ResourceNotFoundException(String.format("Make ti, nemavo stringo %s", name)));
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("Make ti, nemavo idto  %d", id)));
    }

    @Override
    public Product update(Product product, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Product foundProduct = findById(id);
        productRepository.delete(foundProduct);
    }

    @Override
    public Set<Product> findAll() {
        return new HashSet<>(productRepository.findAll());
    }
}
