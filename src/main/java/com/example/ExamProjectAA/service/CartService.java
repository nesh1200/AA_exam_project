package com.example.ExamProjectAA.service;

import com.example.ExamProjectAA.model.Cart;

import java.util.Set;

public interface CartService {

    Cart save(Cart cart);
    Cart findById(Long id);
    Cart update(Cart cart, Long id);
    Set<Cart> findAll();

    void clear(Long cart_id, Long user_id);

}
