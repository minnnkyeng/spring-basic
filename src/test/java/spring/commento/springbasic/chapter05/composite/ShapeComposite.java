package spring.commento.springbasic.chapter05.composite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ShapeComposite implements Shape{
    private final List<Shape> list = new ArrayList<>();
    @Override
    public void draw(String color) {
        list.forEach(shape -> shape.draw(color));
    }
    @Override
    public void move(int x, int y) {
        list.forEach(shape -> shape.move(x, y));
    }
    @Override
    public void print() {
        log.info("\n ================= PRINT =====================");
        list.forEach(Shape::print);
    }
    public void add(Shape shape){
        list.add(shape);
    }
    public void remove(Shape shape){
        list.remove(shape);
    }
    public void clear(){
        list.clear();
    }
}
