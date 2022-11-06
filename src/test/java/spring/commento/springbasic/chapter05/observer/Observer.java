package spring.commento.springbasic.chapter05.observer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Observer {
    private String name;

    public abstract void update();

}
