package spring.commento.springbasic.chapter05.iterator;

import java.util.Iterator;

public interface Aggregate<T> {
    Iterator<T> iterator();
}