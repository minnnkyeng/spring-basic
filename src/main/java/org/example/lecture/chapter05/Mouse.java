package org.example.lecture.chapter05;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mouse implements AnimalInterface{
    @Override
    public void call() {
        log.info("찍찍");
    }
}
