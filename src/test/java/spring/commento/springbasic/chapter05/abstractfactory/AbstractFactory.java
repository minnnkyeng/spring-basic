package spring.commento.springbasic.chapter05.abstractfactory;

public class AbstractFactory {
    private final Button button;
    private final Checkbox checkbox;

    public AbstractFactory(Factory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}


