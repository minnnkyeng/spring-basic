package spring.commento.springbasic.chapter05.iterator;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Slf4j
public class IteratorMain {

    public static void main(String[] args) {
        Team team = new Team("TF팀", 5);
        team.addTeamMember(new Worker("이씨", WorkerType.MANAGER));
        team.addTeamMember(new Worker("김씨", WorkerType.DEVELOPER));
        team.addTeamMember(new Worker("송씨", WorkerType.DEVELOPER));
        team.addTeamMember(new Worker("임씨", WorkerType.PLANNER));
        team.addTeamMember(new Worker("장씨", WorkerType.QA));
        log.info("\n 팀이름 {}",team.getName());
        System.out.println("팀 이름: " + team.getName());
        Iterator<Worker> iterator = team.iterator();
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            log.info("\n =========== \n 이름 : {} \n 직업 {}",worker.getName(),worker.getType().getValue());
        }


    }
}
