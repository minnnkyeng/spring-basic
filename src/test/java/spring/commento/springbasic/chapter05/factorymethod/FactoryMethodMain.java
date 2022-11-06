package spring.commento.springbasic.chapter05.factorymethod;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FactoryMethodMain {
    private static Dialog dialog;

    public static void main(String[] args) {
        factory();
        businessLogic();
    }
    static void factory() {
        if (System.getProperty("os.name").contains("Mac")) {
            dialog = new MacDialog();
        } else {
            dialog = new WindowDialog();
        }
    }
    static void businessLogic() {
        dialog.buttonRender();
    }
}