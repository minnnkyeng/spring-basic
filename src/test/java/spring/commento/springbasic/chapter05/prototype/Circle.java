package spring.commento.springbasic.chapter05.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)// 부모클래스 필드값들도 동일한지 체크 false일시 자신 클래스의 필드 값만 고려합니다.
@NoArgsConstructor
public class Circle extends Shape {
    public int radius;

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    // == , equals의 차이.
    // == 참조비교 두 객체가 메모리 공간이 같은지를 가르키는지 확인

    // equal는 객체의 값이 같은지 확인합니다.

    @Override
    public Shape clone() {
        return new Circle(this);
    }

}


