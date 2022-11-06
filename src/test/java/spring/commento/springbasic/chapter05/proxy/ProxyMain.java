package spring.commento.springbasic.chapter05.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyMain {
    public static void main(String[] args) {

        // 프록시 객체 테스트
//        ProxyFactory proxyFactory = new ProxyFactory();
//        Subject subject = proxyFactory.getObject();
//        subject.action1();
//        subject.action2();
//        log.info("\n proxyFactory proxy test === {}", subject.isProxy());
        log.info("\n ======= 레이지 로딩 테스트 ======");

        //프록시 레이지 로딩 테스트 action1,2
        Proxy proxy1 = new Proxy(Permit.ACTION1);
        proxy1.action1();
        proxy1.action2();
        Proxy proxy2 = new Proxy(Permit.ACTION2);
        proxy2.action1();
        proxy2.action2();
        log.info("\n proxy1,2 proxy test ={} , {}", proxy1.isProxy(), proxy2.isProxy());
//        log.info("\n ===== 프록시 action1 카운트 수 =====");
//        // 프록시 action1 카운트 수 구하기
//        Proxy proxy = new Proxy(Permit.ACTION1);
//        proxy.action1();
//        proxy.action1();
//        proxy.action1();
//        proxy.action1();
//
//        log.info("\n count == {}",proxy.getAction1Count());
    }
}
