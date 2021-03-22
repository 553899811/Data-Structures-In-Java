package com.zhangyong.DataStructures.Queue;

/**
 * <p>ClassName:  </p>
 * <p>Description: 队列接口 </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/8/27 6:26
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    //查看队首的元素;
    E getFront();
}
