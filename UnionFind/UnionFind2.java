package com.zhangyong.DataStructures.UnionFind;

/**
 * <p>Description: </p>
 *
 * @version 1.0.0
 * @date 2020/1/8 17:11
 */
public class UnionFind2 implements UnionFindService {

    /**
     * parent[i] 表示第i个元素所指向的父节点;
     */
    private int[] parent;

    /**
     * 初始化 每一个parent[i] 指向自身,表示每一个元素自己自成一个集合;
     *
     * @param size
     */
    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
        }
    }

    /**
     * 返回并查集中所有元素个数;
     *
     * @return
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程,查找元素p所应的集合编号;
     * O(h)复杂度,h为树的高度;
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("the index of p is out of bound");
        }
        // 不断去查询自己的父亲节点,直到达到根节点;
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    /**
     * 判断元素p 和元素 q 是否所属一个集合;
     * O(h) 复杂度，h 为树的高度;
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
