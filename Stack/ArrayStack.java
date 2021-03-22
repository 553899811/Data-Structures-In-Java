package com.zhangyong.DataStructures.Stack;

import com.zhangyong.DataStructures.Array.Array;

/**
 * <p>ClassName: 数组模拟栈 </p>
 * <p>Description: </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/8/26 9:18
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    //压入元素(满足后进先出)
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //弹出栈顶元素
    @Override
    public E pop() {
        return array.removeLast();
    }

    //获取栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append('[');
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
