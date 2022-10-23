package com.example.lecture.chapter02.repository;

import com.example.lecture.chapter02.User;

import java.util.Map;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
    User modifyById(Long id, User user);
    User deleteById(Long id);
}
