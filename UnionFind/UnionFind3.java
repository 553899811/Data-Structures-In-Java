package com.zhangyong.DataStructures.UnionFind;

/**
 * @author yong.zhang
 * @version 1.0.0
 * @date 2020/1/8 18:36
 */
public class UnionFind3 implements UnionFindService {

    private int[] parent; // parent[i]表示每一个元素所指向的父节点;
    private int[] sz; // sz[i] 表示以  i 为根的集合中元素个数;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        //初始化 , 每一个 parent[i] 指向自己 , 表示每一个元素自己自成一个集合;
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程,查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("the index of p is out of bound");
        }
        // 不断去查询自己的父亲节点,直到达到根节点;
        // 根节点的特点; parent[p] = p;
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
        // 根据两个元素所在树的元素个数不同判断合并方向,
        // 将元素个数少的集合合并到元素个数多的集合上;
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
