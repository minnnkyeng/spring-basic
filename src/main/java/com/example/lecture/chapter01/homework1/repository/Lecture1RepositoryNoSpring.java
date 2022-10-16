package com.example.lecture.chapter01.homework1.repository;

public interface Lecture1RepositoryNoSpring {
    void insertLecture(String key, String value);
    String findLectureByKey(String key);
}
