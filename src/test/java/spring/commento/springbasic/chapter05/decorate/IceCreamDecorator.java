package spring.commento.springbasic.chapter05.decorate;

// 아이스크림 꾸며주는 장식자들 추상클래스
public abstract class IceCreamDecorator implements IceCreamComponent{

    private final IceCreamComponent component;

    protected IceCreamDecorator(IceCreamComponent component) {
        this.component = component;
    }

    @Override
    public String decorate() {
        return component.decorate();
    }


}
