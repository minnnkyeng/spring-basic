package spring.commento.springbasic.chapter05.factorymethod;


public abstract class Dialog {

    public void buttonRender() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * 서브클래스에게 위임
     */
    public abstract Button createButton();
}


