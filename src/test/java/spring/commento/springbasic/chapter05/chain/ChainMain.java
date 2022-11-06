package spring.commento.springbasic.chapter05.chain;

public class ChainMain {
    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.process(new Number(90));
        chain.process(new Number(-50));
        chain.process(new Number(0));
        chain.process(new Number(91));
    }
}
