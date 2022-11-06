package spring.commento.springbasic.chapter05.abstractfactory;

public class MacOSFactory implements Factory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}


