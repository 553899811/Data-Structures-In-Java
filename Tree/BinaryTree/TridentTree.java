package com.zhangyong.DataStructures.Tree.BinaryTree;

/**
 * <p>ClassName:  </p>
 * <p>Description: 三叉树 </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/12/13 13:41
 */
public class TridentTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode middle;
        TreeNode right;

        TreeNode(int val) {
            this.left = null;
            this.middle = null;
            this.right = null;
            this.val = val;
        }
    }

    /**
     * @param root
     * @auther zhangyong
     * @desc 三叉树 镜像
     * @date 2018/12/13  13:57
     * @from JDK 1.8
     */
    public static TreeNode inventTridentTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        inventTridentTree(root.left);
        inventTridentTree(root.middle);
        inventTridentTree(root.right);
        return root;
    }

    /**
     * @param root
     * @auther zhangyong
     * @desc 先序遍历三叉树
     * @date 2018/12/17  9:25
     * @from JDK 1.8
     */
    public static void preOrderTridentTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTridentTree(root.left);
            preOrderTridentTree(root.middle);
            preOrderTridentTree(root.right);
        }
    }

    /**
     *
     * @param root
     * @desc 中序遍历三叉数
     */
    public static void inOrderTridentTree(TreeNode root) {
        if (root != null) {
            preOrderTridentTree(root.left);
        }
    }
}
