package spring.commento.springbasic.chapter05.decorate;

public class Choco extends IceCreamDecorator{
    public Choco(IceCreamComponent component) {
        super(component);
    }

    @Override
    public String decorate() {
        return super.decorate()+decorateIcecream();
    }

    private String decorateIcecream() {
        return "초코";
    }

}
