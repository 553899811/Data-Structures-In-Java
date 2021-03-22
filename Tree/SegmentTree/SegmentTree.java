package com.zhangyong.DataStructures.Tree.SegmentTree;

/**
 * <p>ClassName:  线段树 实体类</p>
 * <p>Description: 线段树</p>
 *
 * @version 1.0.0
 * @date 2019/1/30 13:56
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length << 2];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + ((r - l) >> 1);
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length
                || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("查询参数 queryL,queryR 非法");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        /**
         *
         */
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        /**
         *               [1,10]
         *              /       \
         *         [1,5]         [6,10]
         *         /   \           /   \
         *      [1,3]  [4,5]   [6,8]   [9,10]
         *      /  \    / \    /   \    /  \
         *    [1,2] 3  4  5  [6,7] 8   9   10
         *    /   \           /  \
         *    1   2          6   7
         */
        int mid = l + ((r - l) >> 1);
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    public void update(int index, E e) {
        if (index < 0 ||
                index > data.length) {
            throw new IllegalArgumentException("数组下标越界");
        }
        data[index] = e;
        update(0, 0, data.length - 1, index, e);
    }

    private void update(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + ((r - l) >> 1);
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            update(rightTreeIndex, mid + 1, r, index, e);
        } else {
            update(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 ||
                index >= data.length) {
            throw new IllegalArgumentException("数组下标越界,查询元素失败");
        }
        return data[index];
    }

    private int leftChild(int treeIndex) {
        return treeIndex << 1 | 1;
    }

    private int rightChild(int treeIndex) {
        return (1 + treeIndex) << 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                builder.append(tree[i]);
            } else {
                builder.append("null");
            }
            if (i != tree.length - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
