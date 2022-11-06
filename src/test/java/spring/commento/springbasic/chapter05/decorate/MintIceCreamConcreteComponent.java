package spring.commento.springbasic.chapter05.decorate;


// 아이스크림 뼈대 담당
public class MintIceCreamConcreteComponent implements IceCreamComponent {
    @Override
    public String decorate() {
        return "민트 아이스크림";
    }
}
