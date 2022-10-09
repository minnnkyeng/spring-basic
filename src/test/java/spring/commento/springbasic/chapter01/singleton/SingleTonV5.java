package spring.commento.springbasic.chapter01.singleton;

public class SingleTonV5 {

    private SingleTonV5(){}

    private static class SINGLETON_HOLDER{
        private static final SingleTonV5 INSTANCE = new SingleTonV5();
    }

    public static SingleTonV5 getInstance(){
        return SINGLETON_HOLDER.INSTANCE;
    }
}
