package com.example.lecture.chapter01.homework1.service;

import com.example.lecture.chapter01.homework1.repository.Lecture1RepositoryImpl;

public class Lecture1ServiceImpl implements Lecture1ServiceNoSpring {
    Lecture1RepositoryImpl lecture1Repository;

    public Lecture1ServiceImpl(Lecture1RepositoryImpl lecture1Repository){
        this.lecture1Repository = lecture1Repository;
    }

    @Override
    public void insertLecture(String key, String value) {
        lecture1Repository.insertLecture(key,value);
    }

    @Override
    public String findLectureByKey(String key) {
        return lecture1Repository.findLectureByKey(key);
    }

    @Override
    public void homework(String key) {
        System.out.printf("Lecture 1 과제입니다. %s\n", lecture1Repository.findLectureByKey(key));
    }
}
