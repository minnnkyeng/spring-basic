package com.example.lecture.chapter01.homework2;

import com.example.lecture.chapter01.homework2.service.Lecture1ServiceWithSpring;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Homework1_2 {
    @Autowired
    Lecture1ServiceWithSpring lecture1ServiceWithSpring;

    @Test
    void insertLecture(){
        lecture1ServiceWithSpring.insertLecture("Springboot","스프링부트");
        System.out.println("[Homework1_2 insertLecture] "+lecture1ServiceWithSpring.findLectureByKey("Springboot"));
    }

    @Test
    void findLectureByKey(){
        System.out.println("[Homework1_2 findLectureByKey] "+lecture1ServiceWithSpring.findLectureByKey("Springboot"));
    }
    @Test
    void homework1_2(){
        lecture1ServiceWithSpring.homework("Springboot");
    }


}
