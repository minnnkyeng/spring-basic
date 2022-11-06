package spring.commento.springbasic.chapter05.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        Strategy strategy = new Character();
        strategy.attack();
        strategy.setDelegate(new Knife());
        strategy.attack();
        strategy.setDelegate(new Gun());
        strategy.attack();
    }
}
