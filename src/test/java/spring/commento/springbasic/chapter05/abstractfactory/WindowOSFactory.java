package spring.commento.springbasic.chapter05.abstractfactory;

public class WindowOSFactory implements Factory {

    @Override
    public Button createButton() {
        return new WindowOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowOSCheckbox();
    }
}

