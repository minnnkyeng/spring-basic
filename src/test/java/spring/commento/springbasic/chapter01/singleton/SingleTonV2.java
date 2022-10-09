package spring.commento.springbasic.chapter01.singleton;

public class SingleTonV2 {

    private static SingleTonV2 INSTANCE;

    private SingleTonV2(){}
    //1 , 2
    public static synchronized SingleTonV2 getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SingleTonV2();
        return INSTANCE;
    }
}
