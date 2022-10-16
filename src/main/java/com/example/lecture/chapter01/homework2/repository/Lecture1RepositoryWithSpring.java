package com.example.lecture.chapter01.homework2.repository;

public interface Lecture1RepositoryWithSpring {
    void insertLecture(String key, String value);
    String findLectureByKey(String key);
}
