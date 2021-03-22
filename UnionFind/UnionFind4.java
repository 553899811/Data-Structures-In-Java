package com.zhangyong.DataStructures.UnionFind;

/**
 * <p>Description: </p>
 * <p>Company: http://www.dmall.com</p>
 *
 * @author yong.zhang@dmall.com
 * @version 1.0.0
 */
public class UnionFind4 implements UnionFindService {
    private int[] parent;//parent[i]表示第i个元素所指向的父亲节点;
    private int[] rank;//rank[i]表示第i个元素为根的集合所表示的树的层数;

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("the index of p is out of bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public UnionFind4(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[qRoot] == rank[pRoot]) {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;//维护 qRoot 高度;
        }
    }
}