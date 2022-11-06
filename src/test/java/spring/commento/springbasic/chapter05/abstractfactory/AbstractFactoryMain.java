package spring.commento.springbasic.chapter05.abstractfactory;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        AbstractFactory app = new AbstractFactory(System.getProperty("os.name").contains("Mac")
                                                      ? new MacOSFactory()
                                                      : new WindowOSFactory());
        app.paint();
    }
}



