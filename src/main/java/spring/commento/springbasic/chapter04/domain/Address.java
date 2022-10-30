package spring.commento.springbasic.chapter04.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;

    private String zipCode;

    private String street;
}
