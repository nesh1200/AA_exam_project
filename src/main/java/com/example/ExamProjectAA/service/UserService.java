package com.example.ExamProjectAA.service;

import com.example.ExamProjectAA.model.Cart;
import com.example.ExamProjectAA.model.User;

import java.util.Set;

public interface UserService {

    User save(User user);
    User findByNickname(String name);
    User findById(Long id);
    User update(User user, Long id);
    void delete(Long id);
    Set<User> findAll();

}
