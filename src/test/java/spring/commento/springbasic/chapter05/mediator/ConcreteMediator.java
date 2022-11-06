package spring.commento.springbasic.chapter05.mediator;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagueList;

    public ConcreteMediator() {
        this.colleagueList = new ArrayList<>();
    }

    public ConcreteMediator(List<Colleague> colleagueList) {
        this.colleagueList = new ArrayList<>();
    }

    @Override
    public void addColleague(Colleague colleague) {
        this.colleagueList.add(colleague);
    }

    @Override
    public void mediate(Colleague colleague) {
        colleagueList.forEach(receiverColleague -> {
            log.info("\n [Mediating {} to {} ]", colleague.getName(), receiverColleague.getName());
            receiverColleague.receive(colleague);
        });
    }
}