package com.example.ExamProjectAA.service.Impl;

import com.example.ExamProjectAA.exception.ResourceNotFoundException;
import com.example.ExamProjectAA.model.Cart;
import com.example.ExamProjectAA.model.User;
import com.example.ExamProjectAA.repository.CartRepository;
import com.example.ExamProjectAA.service.CartService;
import com.example.ExamProjectAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Override
    public Cart save(Cart city) {
        return null;
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("Make ti, nemavo idto  %d", id)));
    }

    @Override
    public Cart update(Cart city, Long id) {
        return null;
    }



    @Override
    public Set<Cart> findAll() {
        return null;
    }

    @Override
    public void clear(Long cart_id, Long user_id) {
        //.....
    }
}
