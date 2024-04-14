package myLinkListed;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> {
    //模拟单向链表
    private Node head = null; //头指针
    //单向链表：由一个头指针和多个节点组成
    //类与类之间是组合关系，作为内部类
    //对外隐藏实现细节

    public void addFirst(int value) {
        //1. 链表为空

        //让头指针指向第一个节点即可
        //就能够将这个节点加入链表
        //将新节点的引用值赋值给head
        /*if (head == null) {
            head = new Node(value, null);
        } else {*/

        //2. 链表不为空
        head = new Node(value, head);

        //}
    }

    public void addLast(int value) {
        //添加最后一个节点
        //如果链表不为空：
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    /**
     * 在链表的任意位置插入元素
     *
     * @param index 想要插入的索引位置
     * @param value 想要插入的索引位置处的值
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);  //找到上一个节点
        if (prev == null) {  //找不到的情况
            throw new IllegalArgumentException(String.format("index [%d]", index));
        }
        prev.next = new Node(value, prev.next);
    }


    private Node findLast() {
        //链表为空
        //用p.next()会报出空指针异常
        if (head == null) {
            return null;
        }
        //链表非空
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void loop1(Consumer<Integer> consumer) {
        //设置遍历的指针
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() {
                //询问是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 查找链表中每一个元素的索引值
     *
     * @param index 待查找的索引值
     * @return 返回想要查找的索引值对应的节点对象
     */
    private Node findNode(int index) {
        Node p = head;
        int i = 0;
        //注意：在Java中，第一部分只能写一个初始化的表达式；但是，第三部分可以写多个表达式
        //链表中只能通过遍历获取每一个元素的索引是什么
        while (p != null) {
            if (i == index) {
                return p;
            }
            i++;
            p = p.next;
        }
        return null;  //没有找到的情况
    }

    /**
     * 对外暴露的方法，查找索引处对应的值
     *
     * @param index 待查找的索引值
     * @return 返回索引处对应的元素
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            //如果没找到，抛索引异常
            throw new IllegalArgumentException(String.format("index [%d] ", index));
        }
        return node.value;
    }

    public void removeFirst() {
        if (head != null) {
            //Java会自动管理内存，如果有一个对象，没有任何人去引用，
            //那么java会自动回收该对象
            //head引用的是索引1处的数据的地址值，所以head.next就指向的是索引1处的节点
            head = head.next;
            return;
        }
        throw new NullPointerException("没有元素可以移除");
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node previousNode = findNode(index - 1);  //代表上一个节点
        if (previousNode == null) {
            throw new IllegalArgumentException("索引不合法！" + String.format("index [%d]", index));
        }

        Node removedNode = previousNode.next;
        if (removedNode == null) {
            throw new IllegalArgumentException("索引不合法！" + String.format("index [%d]", index));
        }
        //让上一个节点的next指针指向被删除的节点的next指针所指向的位置
        previousNode.next = removedNode.next;
    }

    /**
     * 使用递归方式遍历链表
     */
    public void loop3(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head, before, after);
    }

    /**
     * 针对某一个节点进行的操作
     *
     * @param p      给定的某一个节点
     * @param before 递归前的操作
     * @param after  递归后的操作
     */
    private void recursion(Node p, Consumer<Integer> before, Consumer<Integer> after) {
        if (p == null) {
            return;
        }
        before.accept(p.value);
        recursion(p.next, before, after);
        after.accept(p.value);
    }

    /**
     * 节点类
     */
    private static class Node {
        //如果用到了外部类的变量，就不能加static，因为static在加载类的时候就被加载进来
        //但是不加的就是在创建对象的时候才被加载进来，时间节点不一样
        private int value;  //该节点的值
        private Node next;  //下一个节点的指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

