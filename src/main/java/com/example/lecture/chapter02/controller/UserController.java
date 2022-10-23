package com.example.lecture.chapter02.controller;

import com.example.lecture.chapter02.User;
import com.example.lecture.chapter02.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/save")
    ResponseEntity<?> save(@ModelAttribute @Valid User user){
        log.info("##### UserController, save, user={}", user);
        userService.save(user);
        return new ResponseEntity<>("sucess, save", HttpStatus.CREATED);
    }

    @RequestMapping("/find/{id}")
    ResponseEntity<?> findById(@PathVariable Long id){
        log.info("##### UserController, findById, id={}", id);
        User result = userService.findById(id);
        if(result==null){
            return ResponseEntity.badRequest().body("error");
        }
        return ResponseEntity.ok().body(result.toString());
    }

    @RequestMapping("/modify/{id}")
    ResponseEntity<?> modifyById(@PathVariable Long id, @ModelAttribute User user){
        log.info("##### UserController, modify, id={}", id);
        User result = userService.modifyById(id, user);
        if(result==null){
            return ResponseEntity.badRequest().body("error");
        }
        return ResponseEntity.ok().body(result.toString());
    }

    @RequestMapping("/delete/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id){
        log.info("##### UserController, deleteById, id={}", id);
        User result = userService.deleteById(id);
        if(result==null){
            return ResponseEntity.badRequest().body("error");
        }
        return ResponseEntity.ok().body("success");
    };
}
