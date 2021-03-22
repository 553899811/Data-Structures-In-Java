package com.zhangyong.DataStructures.Heap;

import com.zhangyong.DataStructures.Array.Array;

/**
 * <p>ClassName:  </p>
 * <p>Description:  数组实现最大堆 </p>
 * <p>Company:  </p>
 *
 * @author zhangyong
 * @version 1.0.0
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        // 关键 : 从最后一个非叶子节点开始;
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
    //3 1 5 4 2 6

    /**
     * 3
     * 1    5
     * 4  2 6
     * arr.length=6;     * @return
     */

    //返回堆中元素个数;
    public int size() {
        return data.getSize();
    }

    //返回布尔值,表示堆中是否为空;
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中 ,一个索引所表示的元素的父亲节点索引值;
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点索引值;
    private int leftChild(int index) {
        return (index << 1) + 1;
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点索引值;
    private int rightChild(int index) {
        return (index << 1) + 2;
    }

    /**
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * @param index
     */
    private void siftUp(int index) {
        //如果当前索引对应的元素值 data[index] > data[parent[index]] 的话,两者交换位置;
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            //根据数组下标交换数组中两个元素位置;
            data.swap(parent(index), index);
            //将当前索引标记为parent(index) 方便继续向上执行上浮操作;
            index = parent(index);
        }
    }

    /**
     * @param index
     */
    private void siftDown(int index) {
        // 左孩子的索引值 < 数组总元素,即表示左子树没有越界;
        while (leftChild(index) < data.getSize()) {
            int l = leftChild(index);
            // 存在右孩子节点,并且右孩子比左孩子的节点值大,则将l赋值为index[right];
            if (l + 1 < data.getSize()
                    && data.get(l + 1).compareTo(data.get(l)) > 0) {

                //++l;
                l = rightChild(index);
                //
            }
            //data[l] 是leftChild和rightChild中的最大值;
            if (data.get(index).compareTo(data.get(l)) > 0) {
                return;
            }
            //交换两者的值
            data.swap(l, index);
            index = l;
        }
    }

    /**
     * @param
     */
    public E findMax() {
        if (data.getSize() <= 0) {
            throw new IllegalArgumentException("数组中没有元素,查找失败");
        }
        E e = data.get(0);
        return e;
    }

    /**
     * @param
     */
    public E extractMax() {
        E max = findMax();
        data.swap(0, data.size() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    /**
     * @param e
     */
    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }
}
