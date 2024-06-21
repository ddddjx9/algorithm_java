package myQueue;

/**
 * 设计循环队列，循环队列是一种线性数据结构，基于链表实现循环队列
 * <p>
 * 先进先出原则并且队尾被连接在队首之后形成一个循环
 * <p>
 * 也被称为环形缓冲器
 */
public class MyCircularQueue {
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private int capacity;
    private Node head = new Node(-1, null);
    private Node tail = head;

    {
        tail.next = head;
    }

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 向循环队列插入一个元素
     *
     * @param value 插入的元素值
     * @return 返回是否插入成功
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail.next = new Node(value, head);
        tail = tail.next;
        size++;
        return true;
    }

    /**
     * 从循环队列头中删除一个元素
     *
     * @return 返回是否删除成功
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        Node first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }
        size--;
        return true;
    }

    /**
     * 从队首获取元素
     *
     * @return 如果队列为空，返回-1,
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.value;
    }

    /**
     * 从队尾获取元素
     *
     * @return 如果队列为空，返回-1
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.value;
    }

    /**
     * 检查循环队列是否为空
     *
     * @return 队列为空，返回true；否则返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检查循环队列是否为满
     *
     * @return 如果队列已满，返回true；如果未满，返回false
     */
    public boolean isFull() {
        return size == capacity;
    }
}

