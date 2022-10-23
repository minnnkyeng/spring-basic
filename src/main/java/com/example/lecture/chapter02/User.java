package com.example.lecture.chapter02;

import lombok.*;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @NotBlank
    private String name;

    @Positive
    private int age;

    @Email
    private String email;

}
