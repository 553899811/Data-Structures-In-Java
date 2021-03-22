package com.zhangyong.DataStructures.UnionFind;

/**
 * <p>Description: </p>
 *
 * @version 1.0.0
 * @date 2020/1/7 11:17
 */
public class UnionFind implements UnionFindService {

    //parent[i]表示第 i 个元素所指向的父节点
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; ++i) {
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素P所对应的集合编号;
     * O(h)复杂度, h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("the index of p is out of bound.");
        }
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 判断元素p和元素q 是否属于同一个集合;
     * // O(h)复杂度, h为树的高度 ; 都是查 根节点元素;
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素P和元素Q所属的集合;
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int qRoot = find(p);
        int pRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        parent[qRoot] = pRoot;
    }
}
