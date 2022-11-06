package spring.commento.springbasic.chapter05.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdapterMain {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg))
            log.info("\n rpeg가 hole에 잘 들어맞음");

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
//         hole.fits(smallSqPeg); // 원하는 기능이지만 컴파일 문제 발생

        // 어댑터 패턴으로 문제 해결
        RoundPeg smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        RoundPeg largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) log.info("\n 잘 들어맞음");
        if (!hole.fits(largeSqPegAdapter)) log.info("\n 잘 들어맞지 않음");
    }
}