package cn.ustb.edu.test;

import myLinkedList.DoublyCircleLinkedListSentinel;
import myLinkedList.DoublyLinkedListSentinel;
import myLinkedList.SinglyLinkedList;
import myLinkedList.SinglyLinkedListSentinel;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class TestLinkedList {
    @Test
    public void main01() {
        SinglyLinkedList list = new SinglyLinkedList();
        //每次都将元素放在链表的头位置，所以我们遍历的时候就是反序的
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    public void main02() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        //增强for循环的底层就是采用迭代器进行遍历的，所有实现iterable接口的类才能够实现增强for循环
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void main03() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        //增强for循环的底层就是采用迭代器进行遍历的，所有实现iterable接口的类才能够实现增强for循环
        list.loop1(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    public void main04() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list.get(10));
    }

    @Test
    public void main05() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.insert(5, 8);
        list.remove(0);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void main06() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.insert(5, 8);
        for (Integer i : list) {
            System.out.println(i);
        }
        /*list.loop1(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        list.loop2(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/
        System.out.println(list.get(8));
    }

    @Test
    public void main07() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.insert(3, 5);
        list.addFirst(9);
        for (Integer i : list) {
            System.out.println(i);
        }

        list.removeFirst();
        list.remove(2);

        for (Integer i : list) {
            System.out.println(i);
        }
        list.remove(5);
    }

    @Test
    public void main08() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addLast(6);
        list.insert(0, 8);
        list.insert(2, 5);
        for (Integer i : list) {
            System.out.println(i);
        }
        list.removeFirst();
        list.removeLast();
        list.remove(1);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void main09() {
        DoublyCircleLinkedListSentinel list = new DoublyCircleLinkedListSentinel();
        /*list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);*/

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        for (Integer i : list) {
            System.out.println(i);
        }

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        //list.removeFirst();

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void main10() {
        DoublyCircleLinkedListSentinel list = new DoublyCircleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeFirst();
        list.removeLast();
        list.removeByValue(3);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void main11() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.loop3(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        }, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
