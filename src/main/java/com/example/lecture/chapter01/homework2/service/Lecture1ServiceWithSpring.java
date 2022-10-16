package com.example.lecture.chapter01.homework2.service;

public interface Lecture1ServiceWithSpring {
    void insertLecture(String key, String value);
    String findLectureByKey(String key);
    void homework(String key);
}
