package spring.commento.springbasic.chapter05.factorymethod;

public class MacDialog extends Dialog {

    @Override
    public Button createButton() {
        return new MacButton();
    }
}

