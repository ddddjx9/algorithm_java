package myStack.dataStructure;

import myStack.impl.Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    //需要一个底层的数组和相应的指针
    //这里我们不给数组进行动态扩容，所以定义为常量即可
    private final E[] array;
    private int top; //指针

    /*
    底             顶（以右边作为底，性能更高）
    0    1    2    3
                        t(index=4)
    如果指针和数组长度相等，表示栈满了
     */

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = top;

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public E next() {
                return array[--index];
            }
        };
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        //返回栈顶元素，每次添加元素后top++，所以top-1后才代表栈顶元素
        //删除元素：top-1，下次添加元素时覆盖此元素即可
        return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }
}
