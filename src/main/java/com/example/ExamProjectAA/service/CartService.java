package com.example.ExamProjectAA.service;

import com.example.ExamProjectAA.model.Cart;

import java.util.Set;

public interface CartService {

    Cart save(Cart cart);
    Cart findByName(String name);
    Cart findById(Long id);
    Cart update(Cart cart, Long id);
    void delete(Long id);
    Set<Cart> findAll();

}
