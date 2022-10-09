package spring.commento.springbasic.chapter01.singleton;

public class SingleTonV4 {

    private static volatile SingleTonV4 INSTANCE;

    private SingleTonV4(){}

    public static SingleTonV4 getInstance(){
        if(INSTANCE == null){
            synchronized (SingleTonV4.class){
                if(INSTANCE == null){
                    INSTANCE = new SingleTonV4();
                }
            }
        }
        return INSTANCE;
    }
}
