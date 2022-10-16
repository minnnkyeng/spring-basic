package com.example.lecture.chapter01.homework2.service;

import com.example.lecture.chapter01.homework2.repository.Lecture1RepositorySpringImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lecture1ServiceSpringImpl implements Lecture1ServiceWithSpring {

    @Autowired
    Lecture1RepositorySpringImpl lecture1RepositorySpring;

    @Override
    public void insertLecture(String key, String value) {
        lecture1RepositorySpring.insertLecture(key,value);
    }

    @Override
    public String findLectureByKey(String key) {
        return lecture1RepositorySpring.findLectureByKey(key);
    }

    @Override
    public void homework(String key) {
        System.out.println("Lecture 1 과제입니다. "+lecture1RepositorySpring.findLectureByKey(key));
    }
}
