package spring.commento.springbasic.chapter05.proxy;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Proxy implements Subject {
    private Subject subject;
    private Permit permit;
    private int action1Count;
    public Proxy(Permit permit) {
        log.info("\n {}",this.getClass().getSimpleName()+" 객체 생성(레이지 로딩)");
        this.permit = permit;
        this.action1Count = 0;
    }
    public Proxy(Subject subject) {
        log.info("\n {}",this.getClass().getSimpleName()+" 객체 생성");
        this.subject = subject;
    }
    @Override
    public String action1() {
        log.info("\n {}",this.getClass().getSimpleName()+" action1");
        action1Count++;
        return "프록시로 action1 메서드 대체";
    }
    @Override
    public String action2() {
        log.info("\n {}",this.getClass().getSimpleName()+" action2");
        if (Permit.ACTION2 != this.permit) {
            return "action2 의 실행 권한이 없습니다.";
        }
        if (this.subject == null) {
            this.real();
        }
        return this.subject.action2();
    }
    private void real() {
        this.subject = new RealSubject();
    }
    public boolean isProxy() {
        return true;
    }
}
