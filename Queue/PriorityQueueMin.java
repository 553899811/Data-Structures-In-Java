package com.zhangyong.DataStructures.Queue;

import com.zhangyong.DataStructures.Heap.MinHeap;

/**
 * @author zhangyong
 */
public class PriorityQueueMin<E extends Comparable<E>> implements Queue<E> {

    private MinHeap<E> minHeap;

    public PriorityQueueMin() {
        this.minHeap = new MinHeap<>();
    }

    @Override
    public int getSize() {
        return minHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        minHeap.add(e);
    }

    @Override
    public E dequeue() {
        return minHeap.extractMin();
    }

    @Override
    public E getFront() {
        return minHeap.findMin();
    }
}
