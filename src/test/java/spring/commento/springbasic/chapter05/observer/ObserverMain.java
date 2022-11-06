package spring.commento.springbasic.chapter05.observer;

public class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new Members();
        Observer observer1 = new UserA("saechim");
        Observer observer2 = new UserA("commento");
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObserver();
    }
}
