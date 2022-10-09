package spring.commento.springbasic.chapter01.singleton;

public class SingleTonV1 {

    private static  SingleTonV1 INSTANCE;

    private SingleTonV1(){}
    //1 , 2
    public static SingleTonV1 getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SingleTonV1();
        return INSTANCE;
    }
}
