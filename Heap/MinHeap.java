package com.zhangyong.DataStructures.Heap;

import com.zhangyong.DataStructures.Array.Array;

/**
 * <p>ClassName:  </p>
 * <p>Description: 数组实现最小堆 </p>
 * <p>Company: http://www.shopin.net</p>
 *
 * @author zhangyong@shopin.cn
 * @version 1.0.0
 * @date 2018/11/15 8:09
 */
public class MinHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    //TODO
    public MinHeap(E[] arr) {
        data = new Array<>();

    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have a parent");
        }
        return (index - 1) >> 1;
    }

    private int leftChild(int index) {
        return (index << 1) + 1;
    }

    private int rightChild(int index) {
        return (index << 1) + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * @param index
     * @desc 添加元素之后, 上浮操作, 更新整棵树的最小值;
     * @date 2018/11/30  21:10
     * @from JDK 1.8
     */
    private void siftUp(int index) {
        //如果当前索引位置的元素比其父亲节点值要小;
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) > 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }
    /**
     * @desc 删除元素之后,下沉操作,更新二叉堆的堆顶元素;
     * @date 2018/11/30  21:14
     * @param index
     * @from JDK 1.8
     */
    private void siftDown(int index){
        // 左子树的索引 < 数组总元素
        while (leftChild(index) < data.getSize()) {
            int l = leftChild(index);
            if (l + 1 < data.getSize() && data.get(l + 1).compareTo(data.get(l)) < 0) {
                l += 1;
            }
            if (data.get(index).compareTo(data.get(l)) < 0) {
                return;
            }
            data.swap(index, l);
            index = l;
        }
    }

    /**
     * @param
     * @auther zhangyong@shopin.cn
     * @desc 找到堆中最小值;
     * @date 2019/1/14  22:19
     * @from JDK 1.8
     */
    public E findMin() {
        if (data.getSize() < 0) {
            throw new IllegalArgumentException("堆为空,无法查询");
        }
        E min = data.get(0);
        return min;
    }

    /**
     * @param
     * @auther zhangyong@shopin.cn
     * @desc 取出堆中最小值
     * @date 2019/1/14  22:20
     * @from JDK 1.8
     */
    public E extractMin() {
        E min = findMin();
        data.swap(0, data.size() - 1);
        data.removeLast();
        siftDown(0);
        return min;
    }
}
