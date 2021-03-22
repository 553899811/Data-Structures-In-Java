package com.zhangyong.DataStructures.Heap;

import java.util.Random;

/**
 * <p>ClassName:  </p>
 * <p>Description: 测试最大堆 </p>
 *
 * @version 1.0.0
 * @date 2018/11/25 23:08
 */
public class Main {
    private static double testHeap(Integer[] data, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(data);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer datum : data) {
                maxHeap.add(datum);
            }
        }
        int[] arr = new int[data.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < data.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error,出现了前者元素小于后者元素的情况");
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / ((1 << 10) * 1.0);
    }

    public static void main(String[] args) {
        int n = 1 << 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(data, false);
        System.out.println("不用heapify构建10000规模的最大堆消耗时间为:" + time1);
        double time2 = testHeap(data, true);
        System.out.println("用heapify构建10000规模的最大堆消耗时间为:" + time2);
        System.out.println("Test MaxHeap Completed");
    }
}
