package com.example.ExamProjectAA.service.Impl;

import com.example.ExamProjectAA.exception.DuplicateRecordException;
import com.example.ExamProjectAA.exception.ResourceNotFoundException;
import com.example.ExamProjectAA.model.User;
import com.example.ExamProjectAA.repository.UserRepository;
import com.example.ExamProjectAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        try{
            return userRepository.save(user);
        }catch(Exception e){
            throw new DuplicateRecordException(String.format("Make ti, toa user is existing %s", user.getNickname()));
        }
    }

    @Override
    public User findByNickname(String name) {
        return userRepository.findByNickname(name).orElseThrow(()-> new ResourceNotFoundException(String.format("Make ti, nemavo stringo %s", name)));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("Make ti, nemavo idto %d", id)));
    }

    @Override
    public User update(User user, Long id) {
        User foundUser = findById(id);
        User toUpdate = User.builder()
                .id(foundUser.getId())
                .first_name(user.getFirst_name())
                .last_name(user.getLast_name())
                .build();
        return userRepository.save(toUpdate);
    }

    @Override
    public void delete(Long id) {
        User foundUser = findById(id);
        userRepository.delete(foundUser);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }
}
