package spring.commento.springbasic.chapter03.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private Long id;

    private String companyName;

    private List<User> users = new ArrayList<>();

}