package com.zhangyong.DataStructures.Queue;

import com.zhangyong.DataStructures.Heap.MaxHeap;

/**
 * <p>ClassName:  </p>
 * <p>Description: 最大堆实现优先队列</p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2019/1/13 22:06
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    //入队操作;
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    //出队操作
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
