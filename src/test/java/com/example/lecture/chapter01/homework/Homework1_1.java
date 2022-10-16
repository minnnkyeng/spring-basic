package com.example.lecture.chapter01.homework;

import com.example.lecture.chapter01.homework1.repository.Lecture1RepositoryImpl;
import com.example.lecture.chapter01.homework1.service.Lecture1ServiceImpl;
import org.junit.jupiter.api.Test;

public class Homework1_1 {

    Lecture1ServiceImpl lecture1Service = new Lecture1ServiceImpl(new Lecture1RepositoryImpl());

    @Test
    void insertLecture(){
        lecture1Service.insertLecture("Springboot","스프링부트");
    }
    @Test
    void findLectureByKey(){
        System.out.println(lecture1Service.findLectureByKey("Springboot"));
    }
    @Test
    void homework(){
        lecture1Service.homework("Springboot");
    }
}
