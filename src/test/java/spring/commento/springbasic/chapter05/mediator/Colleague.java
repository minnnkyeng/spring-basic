package spring.commento.springbasic.chapter05.mediator;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public abstract class Colleague {
    private Mediator mediator;
    private String message;
    private final String name;
    private final ColleagueType type;

    protected Colleague(String name, ColleagueType type) {
        this.name = name;
        this.type = type;
    }

    public void send() {
        log.info("\n {} send()",this.name);
        mediator.mediate(this);
    }

    public abstract void receive(Colleague colleague);
}
