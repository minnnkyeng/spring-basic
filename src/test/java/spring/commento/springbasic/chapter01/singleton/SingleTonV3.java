package spring.commento.springbasic.chapter01.singleton;

public class SingleTonV3 {

    private static SingleTonV3 INSTANCE = new SingleTonV3();

    private SingleTonV3(){}

    public static SingleTonV3 getINSTANCE(){
        return INSTANCE;
    }

}
