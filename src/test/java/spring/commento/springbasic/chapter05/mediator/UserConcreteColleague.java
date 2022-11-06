package spring.commento.springbasic.chapter05.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserConcreteColleague extends Colleague {
    public UserConcreteColleague(String name) {
        super(name, ColleagueType.USER);
    }

    @Override
    public void receive(Colleague colleague) {
        if (ColleagueType.SYSTEM == colleague.getType()) {
            log.info("\n [SYSTEM]");
        } else if (ColleagueType.USER == colleague.getType()) {
            log.info("[ {} ] ",colleague.getName());
        }
        log.info("\n {}",colleague.getMessage());
    }
}
