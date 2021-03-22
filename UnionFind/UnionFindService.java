package com.zhangyong.DataStructures.UnionFind;

/**
 * <p>Description: </p>
 *
 * @version 1.0.0
 * @date 2020/1/7 11:16
 */
public interface UnionFindService {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
