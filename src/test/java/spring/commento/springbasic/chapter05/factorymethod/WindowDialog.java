package spring.commento.springbasic.chapter05.factorymethod;

public class WindowDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowButton();
    }
}