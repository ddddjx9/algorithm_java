package myQueue.dataStructure;

/**
 * 使用数组模拟队列，编写一个ArrayQueue类
 */
public class ArrayImitateQueue {
    private final int maxSize; //表示数组的最大容量
    private int front; //队列的头指针
    private int rear; //队列尾指针
    private final int[] arr; //用于存放数据

    //创建队列的构造器
    public ArrayImitateQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，front指向队列头的前一个位置
        rear = -1; //指向队列尾部，指向队列尾部的具体数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("不能加入数据！");
            return;
        }
        rear++; //让rear后移
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常来处理
            System.out.println("头指针的位置：" + front);
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        System.out.println("头指针的位置：" + front);
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}
