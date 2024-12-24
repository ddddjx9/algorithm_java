package dynamicArrayDemo;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;  //数组的逻辑大小
    private int capacity = 8;  //数组的容量
    private int[] arr = {};  //避免创建出数组后不使用的情况，
    //当用户开始创建数组的时候，我们再将容量为8的数组创建出来使用即可

    /**
     * 向动态数组的最后位置添加元素
     *
     * @param element 待添加的元素
     */
    public void addLast(int element) {
        // arr[index] = element;
        // size++;
        add(size, element);
    }

    /**
     * 向数组中某一位置插入元素
     *
     * @param index   想要插入的索引位置
     * @param element 想要插入的元素
     */
    public void add(int index, int element) {
        //先将不合法的输入全部处理掉
        //如果输入的数据不合法，那么就报错
        //没有报错，说明输入的数据一定是合法的

        checkAndGrow();

        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("输入的索引不合法！");
        }
        if (index < size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }

        arr[index] = element;
        size++;
    }

    /**
     * 动态数组扩容的代码
     */
    private void checkAndGrow() {
        //如果容量不够，需要将数组先扩容，然后再走添加元素的具体逻辑
        //检查当前数组容量
        //避免创建出数组后不使用的情况，
        //当用户开始创建数组的时候，我们再将容量为8的数组创建出来使用即可
        if (size == 0) {
            arr = new int[capacity];
        }
        if (size == capacity) {
            //表示已经放满了，应该进行扩容
            //扩容到原来的1.5倍
            capacity += capacity >> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            //用新数组的地址值取代原来旧数组的地址值
            arr = newArr;
        }
    }

    /**
     * 删除动态数组的元素
     *
     * @param index 要删除的元素的索引
     * @return 返回被删除的元素
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("输入的索引不合法！");
        }
        int removed = arr[index];
        if (index < size - 1) {
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
            size--;
        }
        return removed;
    }

    /**
     * 通过索引获取元素的方法
     *
     * @param index 想要获取的元素的索引位置
     * @return 返回索引位置对应的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("输入的索引不合法！");
        }
        return arr[index];
    }

    /**
     * 遍历方法一：Lambda表达式遍历
     *
     * @param consumer 遍历要执行的操作，形参，每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }

        //forEach提供元素值arr[i]
        //函数接口返回void
    }

    /**
     * 遍历方式二：迭代器遍历
     *
     * @return 返回一个迭代器对象，调用匿名内部类中的方法
     */
    @Override
    public @NotNull Iterator<Integer> iterator() {
        return new Iterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                //有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {
                //返回当前元素
                //并将指针移动到下一个元素
                return arr[i++];
            }
        };
    }

    public IntStream stream() {
        //Arrays.copyRange拷贝元素，含头不含尾
        //[0,size)
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }
}
