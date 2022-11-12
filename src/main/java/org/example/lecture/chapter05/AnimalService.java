package org.example.lecture.chapter05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnimalService {
    public void getAnimalSounds(String animalName){
        animalName = animalName.toUpperCase();
        if(animalName.equalsIgnoreCase("DOG")){
            new Dog().call();
        }else if(animalName.equalsIgnoreCase("CAT")){
            new Cat().call();
        }else if(animalName.equalsIgnoreCase("MOUSE")){
            new Mouse().call();
        }else{
            log.info("DOG, CAT, MOUSE 중 입력하세요.");
        }
    }

}
