package spring.commento.springbasic.chapter05.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    @Override
    public double getRadius() {
        // 반지름 계산
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }
}

