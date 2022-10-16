package com.example.lecture.chapter01.homework1.service;

public interface Lecture1ServiceNoSpring {
    void insertLecture(String key, String value);
    String findLectureByKey(String key);
    void homework(String key);
}
