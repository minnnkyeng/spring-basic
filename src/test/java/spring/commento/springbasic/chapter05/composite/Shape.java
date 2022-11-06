package spring.commento.springbasic.chapter05.composite;

public interface Shape {
    void draw(String color);

    void move(int x, int y);

    void print();

    default String getDefaultColor(){
        return "BLUE";
    }
}
