package com.zhangyong.DataStructures.UnionFind;

import java.util.Random;

/**
 * <p>Description: </p>
 *
 * @version 1.0.0
 * @date 2020/1/14 21:02
 */
public class Main {
    private static double testUF(UnionFindService uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; ++i) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }
        for (int i = 0; i < m; ++i) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;
        UnionFind2 uf1 = new UnionFind2(size);
        System.out.println("UnionFind1 :" + testUF(uf1, m) + " s");
        UnionFind6 uf2 = new UnionFind6(size);
        System.out.println("UnionFind2 :" + testUF(uf2, m) + " s");
    }
}
