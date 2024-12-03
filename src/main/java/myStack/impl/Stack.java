package myStack.impl;

public interface Stack<E> {
    /**
     * 向栈顶压入元素
     *
     * @param value 待压入值
     * @return 压入成功返回true, 压入失败返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     *
     * @return 栈不为空则返回被弹出的元素，栈为空则返回null
     */
    E pop();

    /**
     * 返回栈顶元素，不移除
     *
     * @return 栈不为空则返回栈顶元素，栈为空则返回null
     */
    E peek();

    /**
     * 判断栈是否为空
     *
     * @return 如果栈为空则返回true，不为空则返回false
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     *
     * @return 如果栈已满则返回true，栈没有满则返回false
     */
    boolean isFull();
}
