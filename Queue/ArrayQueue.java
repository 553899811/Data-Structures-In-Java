package com.zhangyong.DataStructures.Queue;

import com.zhangyong.DataStructures.Array.Array;

/**
 * <p>ClassName:  </p>
 * <p>Description: 数组模拟队列 </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/8/27 6:27
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    public int size() {
        return getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //压入队列
    @Override
    public void enqueue(E e) {
        //在数组尾部添加元素
        array.addLast(e);
    }

    /**
     * @auther zhangyong
     * @desc 弹出队列
     * @date 2018/8/28  22:36
     * @param 时间复杂度 O(n) 将首个元素移除之后,后续元素都要向前移动一个位置
     * @from JDK 1.8
     */
    @Override
    public E dequeue() {
        //移除数组头部元素
        return array.removeFirst();
}

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            //按照索引顺序遍历元素,谁位置靠前谁
            sb.append(array.get(i));
            if (i != array.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
