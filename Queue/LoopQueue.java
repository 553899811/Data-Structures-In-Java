package com.zhangyong.DataStructures.Queue;

/**
 * <p>ClassName:  </p>
 * <p>Description: 循环队列</p>
 *
 * @author zhangyong
 * @email: littledream1502@gmail.com
 * @version 1.0.0
 * @date 2018/8/29 7:45
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    //维护首尾元素
    private int front, tail;
    private int size;

    /**
     * @param capacity 容量
     *                 size     实际大小
     * @auther zhangyong@shopin.cn
     * @desc 数组中要浪费一个空间;
     * @date 2018/8/29  7:53
     * @from JDK 1.8
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    //头尾相等标志着队列为空;
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //原队列满员,扩容1倍
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() << 1);
        }
        data[tail] = e;
        //维护尾部指针
        tail = (tail + 1) % data.length;
        ++size;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //front可能不会再索引为0 的位置上;
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * @param
     * @auther zhangyong@shopin.cn
     * @desc 时间复杂度 O(1) 均摊
     * @date 2018/9/2  22:22
     * @from JDK 1.8
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,无法出队");
        }
        E first = data[front];
        //help gc
        data[front] = null;
        //出队维护头指针元素
        front = (front + 1) % data.length;
        --size;
        if (size == getCapacity() >> 2 && size != getCapacity() >> 1) {
            //缩容操作;
            resize(getCapacity() >> 1);
        }
        return first;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,无法获取元素值");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: 大小 = %d ,capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
