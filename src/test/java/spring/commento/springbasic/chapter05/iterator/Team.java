package spring.commento.springbasic.chapter05.iterator;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Slf4j
public class Team implements Aggregate<Worker> {
    private final Worker[] workers;
    private final String name;
    private int lastIndex = 0;
    public Team(String name, int size) {
        this.name = name;
        workers = new Worker[size];
    }
    public void addTeamMember(Worker worker) {
        if (lastIndex < workers.length) {
            this.workers[lastIndex] = worker;
            lastIndex++;
        } else {
            log.info("\n 팀이 가득 찼습니다");
        }
    }
    public Worker getWorker(int index) {
        return workers[index];
    }
    public int getSize() {
        return workers.length;
    }
    public String getName() {
        return name;
    }
    @Override
    public Iterator<Worker> iterator() {
        return new TeamIterator(this);
    }
}
