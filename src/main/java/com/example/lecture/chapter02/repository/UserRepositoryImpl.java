package com.example.lecture.chapter02.repository;

import com.example.lecture.chapter02.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository{
    private static Map<Long, User> userMap = new HashMap<>();
    private static Long id = 0L;


    @Override
    public User save(User user) {
        userMap.put(++id,user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userMap.get(id);
    }

    @Override
    public User modifyById(Long id, User user) {
        User result = userMap.get(id);
        if(result==null){
            return null;
        }

        if(user.getName()!=null)
            result.setName(user.getName());
        if(user.getAge()<0)
            result.setAge(user.getAge());
        if(user.getEmail()!=null)
            result.setEmail(user.getEmail());

        return userMap.get(id);
    }

    @Override
    public User deleteById(Long id) {
        User result = userMap.get(id);
        if(result==null)
            return null;

        return userMap.remove(id);
    }
}
