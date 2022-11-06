package spring.commento.springbasic.chapter05.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoundHole {
    private double radius;

    public boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }
}


