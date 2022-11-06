package spring.commento.springbasic.chapter05.state;

public class StateMain {
    public static void main(String[] args) {
        TV tv = new TV();
        tv.button();
        tv.button();

        Radio radio = new Radio();
        radio.button();
        radio.button();

    }
}
