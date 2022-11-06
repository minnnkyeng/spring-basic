package spring.commento.springbasic.chapter05.decorate;

public class Oreo extends IceCreamDecorator{
    public Oreo(IceCreamComponent component) {
        super(component);
    }

    @Override
    public String decorate() {
        return super.decorate()+decorateIcecream();
    }

    private String decorateIcecream() {
        return "오레오";
    }

}
