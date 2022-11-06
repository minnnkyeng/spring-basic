package spring.commento.springbasic.chapter05.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemConcreteColleague extends Colleague {
    public SystemConcreteColleague(String name) {
        super(name, ColleagueType.SYSTEM);
    }

    @Override
    public void receive(Colleague colleague) {
        log.info("\n System can't receive messages");
    }
}
