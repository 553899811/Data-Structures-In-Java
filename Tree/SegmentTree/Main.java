package com.zhangyong.DataStructures.Tree.SegmentTree;

public class Main {

    public static void main(String[] args) {

        Integer[] nums = {
                1,3,4,8
        };
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree.query(0, 1));
    }
}
