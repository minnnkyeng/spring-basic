package com.example.lecture.chapter01.homework2.repository;

import com.example.lecture.chapter01.SingletonClass;
import org.springframework.stereotype.Repository;

@Repository
public class Lecture1RepositorySpringImpl implements Lecture1RepositoryWithSpring {
    @Override
    public void insertLecture(String key, String value) {
        SingletonClass.getInstance().insertLecture(key, value);
    }
    @Override
    public String findLectureByKey(String key) {
        return SingletonClass.getInstance().findLectureByKey(key);
    }
}
