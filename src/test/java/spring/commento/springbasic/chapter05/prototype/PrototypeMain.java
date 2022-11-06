package spring.commento.springbasic.chapter05.prototype;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PrototypeMain {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);
        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);
        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);
        Shape clone = rectangle.clone(); // == 다르지만 equals는 같은
        shapes.add(clone);
        cloneAndCompare(shapes, new ArrayList<>());
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {


        shapes.stream().map(Shape::clone).forEach(shapesCopy::add);
        for (int i = shapes.size() - 1; i >= 0; i--) {
            log.info(shapes.get(i) != shapesCopy.get(i)
                         ? shapes.get(i).equals(shapesCopy.get(i)) ?
                "\n 객체 내용은 같지만 다른객체입니다1"
                : "\n 객체 주소도, 내용도 다릅니다2" :
                         "\n  완전히 동일한 object입니다.3");
        }
    }
}