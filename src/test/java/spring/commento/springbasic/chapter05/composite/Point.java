package spring.commento.springbasic.chapter05.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class Point {
    private int x = 0;
    private int y = 0 ;
    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }
}
