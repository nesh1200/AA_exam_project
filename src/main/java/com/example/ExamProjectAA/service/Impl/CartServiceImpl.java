package com.example.ExamProjectAA.service.Impl;

import com.example.ExamProjectAA.model.Cart;
import com.example.ExamProjectAA.repository.CartRepository;
import com.example.ExamProjectAA.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart save(Cart city) {
        return null;
    }

    @Override
    public Cart findByName(String name) {
        return null;
    }

    @Override
    public Cart findById(Long id) {
        return null;
    }

    @Override
    public Cart update(Cart city, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<Cart> findAll() {
        return null;
    }
}
