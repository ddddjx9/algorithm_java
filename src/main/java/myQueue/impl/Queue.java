package myQueue.impl;

import java.util.Iterator;

public interface Queue<E> {
    int size();

    boolean isEmpty();

    boolean isFull();

    Iterator<E> iterator();


    boolean offer(E e);


    E poll();

    E peek();
}
