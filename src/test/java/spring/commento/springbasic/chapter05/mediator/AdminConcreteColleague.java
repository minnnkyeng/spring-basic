package spring.commento.springbasic.chapter05.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminConcreteColleague extends Colleague {
    public AdminConcreteColleague(String name) {
        super(name, ColleagueType.ADMIN);
    }

    @Override
    public void receive(Colleague colleague) {
        log.info("\n Admin can't receive messages");
    }
}
