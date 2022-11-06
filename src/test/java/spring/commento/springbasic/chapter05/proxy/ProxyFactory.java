package spring.commento.springbasic.chapter05.proxy;

public class ProxyFactory {
    public Subject getObject() {
        return new Proxy(new RealSubject());
    }
}
