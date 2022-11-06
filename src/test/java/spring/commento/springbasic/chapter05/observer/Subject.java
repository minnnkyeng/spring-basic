package spring.commento.springbasic.chapter05.observer;

public interface Subject {
    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserver();
}
