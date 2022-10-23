package com.example.lecture.chapter02.service;

import com.example.lecture.chapter02.User;
import com.example.lecture.chapter02.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User modifyById(Long id, User user) {
        return userRepository.modifyById(id, user);
    }

    @Override
    public User deleteById(Long id) {
        return userRepository.deleteById(id);
    }
}
