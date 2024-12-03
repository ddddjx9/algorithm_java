package cn.edu.ustb.testDataStructure;

import myLinkedList.dataStructure.DoublyCircleLinkedListSentinel;
import myLinkedList.dataStructure.DoublyLinkedListSentinel;
import myLinkedList.dataStructure.SinglyLinkedList;
import myLinkedList.dataStructure.SinglyLinkedListSentinel;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedList {
    @Test
    public void testAddFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        //每次都将元素放在链表的头位置，所以我们遍历的时候就是反序的
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    public void testEnhancedFor() {
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
    public void testLoop() {
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
    public void testAddLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        assertEquals(4, list.get(3));
    }

    @Test
    public void testInsertAndRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.insert(5, 8);
        list.remove(0);
        assertIterableEquals(List.of(2, 3, 4, 5, 8), list);
    }

    @Test
    public void testGet() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.insert(5, 8);
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
        assertThrows(IllegalArgumentException.class, () -> {
            list.get(8);
        });
    }

    @Test
    public void testRemoveFirst() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.insert(3, 5);
        list.addFirst(9);
        assertIterableEquals(List.of(9, 1, 2, 3, 5), list);

        list.removeFirst();
        list.remove(2);

        assertIterableEquals(List.of(1, 2, 5), list);
        assertThrows(IllegalArgumentException.class, () -> {
            list.remove(5);
        });
    }

    @Test
    public void testDoublyLinkedListSentinel() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addLast(6);
        list.insert(0, 8);
        list.insert(2, 5);
        assertIterableEquals(List.of(8, 1, 5, 6), list);
        list.removeFirst();
        list.removeLast();
        list.remove(1);
        assertIterableEquals(List.of(1), list);
    }

    @Test
    public void testDoublyLinkedListAddLast() {
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

        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        //list.removeFirst();

        assertIterableEquals(List.of(), list);
    }

    @Test
    public void testRemove() {
        DoublyCircleLinkedListSentinel list = new DoublyCircleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeFirst();
        list.removeLast();
        list.removeByValue(3);

        assertIterableEquals(List.of(2, 4), list);
    }

    @Test
    public void testSinglyLinkedListLoop() {
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
