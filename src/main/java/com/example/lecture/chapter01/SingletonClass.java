package com.example.lecture.chapter01;

import java.util.HashMap;

public class SingletonClass {
    private static final SingletonClass INSTANCE = new SingletonClass();

    private SingletonClass(){

    }

    public static SingletonClass getInstance(){
        return INSTANCE;
    }

    HashMap<String, String> map = new HashMap<>(){{
        put("JAVA","자바");
        put("Spring","스프링");
    }};

    // 데이터 저장
    public void insertLecture(String key, String value){
        if(map.containsKey(key))
            System.out.println("이미 존재하는 key 값 입니다.");
        else
            map.put(key, value);
    }

    // 데이터 조회
    public String findLectureByKey(String key){
        String result = map.get(key);
        System.out.println("singletonClass findLectureByKey : "+key+", "+map.get(key));
        if(result==null)
            result = "COMMENTO";
        return result;
    }
}
