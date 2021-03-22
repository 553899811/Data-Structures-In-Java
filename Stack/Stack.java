package com.zhangyong.DataStructures.Stack;

/**
 * <p>ClassName: 堆栈接口 </p>
 * <p>Description: </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/8/26 9:17
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
