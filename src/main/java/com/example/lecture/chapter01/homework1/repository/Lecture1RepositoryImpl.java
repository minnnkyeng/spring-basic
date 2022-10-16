package com.example.lecture.chapter01.homework1.repository;

import com.example.lecture.chapter01.SingletonClass;

public class Lecture1RepositoryImpl implements Lecture1RepositoryNoSpring {
    @Override
    public void insertLecture(String key, String value) {
        SingletonClass.getInstance().insertLecture(key, value);
    }

    @Override
    public String findLectureByKey(String key) {
        return SingletonClass.getInstance().findLectureByKey(key);
    }
}
