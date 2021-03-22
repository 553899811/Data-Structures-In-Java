package com.zhangyong.DataStructures.UnionFind;

/**
 * <p>Description: </p>
 * <p>Company: http://www.dmall.com</p>
 *
 * @author yong.zhang@dmall.com
 * @version 1.0.0
 * @date 2020/1/25 17:30
 */
public class UnionFind6 implements UnionFindService {
    private int[] parent;
    private int[] rank;

    @Override
    public int getSize() {
        return parent.length;
    }

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        if (p > parent.length || p < 0) {
            throw new IllegalArgumentException("the index of array is out of bound");
        }
        if (p != parent[p]) {
            //路径压缩;
            //递归查找;
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
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
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;//维护pRoot 树的高度;
        }
    }
}
