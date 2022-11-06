package spring.commento.springbasic.chapter05.composite;

public class CompositeMain {

    public static void main(String[] args) {
        Shape rectangle1 = new Rectangle();
        Shape rectangle2 = new Rectangle();
        Shape circle = new Circle();

        ShapeComposite composite = new ShapeComposite();
        composite.add(rectangle1);
        composite.add(rectangle2);
        composite.add(circle);

        composite.print();
        composite.draw("BLACK");
        composite.print();
        composite.move(1,1);
        composite.print();
        composite.remove(circle);
        composite.print();
    }


}
