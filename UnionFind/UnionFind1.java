package com.zhangyong.DataStructures.UnionFind;

/**
 * <p>Description: </p>
 *
 * @author yong.zhang
 * @version 1.0.0
 * @date 2020/1/8 17:01
 */
public class UnionFind1 implements UnionFindService {

    private int[] ids;

    //初始化,每一个id[i]指向自己,没有合并的元素;
    public UnionFind1(int size) {
        ids = new int[size];
        for (int i = 0; i < size; ++i) {
            ids[i] = i;
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    /**
     * 查找元素p所对应的集合编号;
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p > ids.length) {
            throw new IllegalArgumentException("the index of p is out of bound");
        }
        return ids[p];
    }

    /**
     * 判断元素p 和元素 q 是否所属一个集合;
     * O(1) 复杂度;
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
     * 合并元素p 和元素q 所属的集合;
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        for (int i = 0; i < ids.length; ++i) {
            if (ids[i] == pRoot) {
                ids[i] = qRoot;
            }
        }
    }
}
