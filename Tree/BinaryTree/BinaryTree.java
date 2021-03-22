package com.zhangyong.DataStructures.Tree.BinaryTree;

import java.util.*;

/**
 * 二叉树
 */
public class BinaryTree<E> {

    /**
     * @desc 根节点
     * @author zhangyong
     */
    private static Node root = null;

    /**
     * 节点类
     */
    static class Node<E> {

        E key;
        Node left, right;

        Node() {

        }

        Node(E item) {
            this.key = item;
            left = right = null;
        }
    }

    BinaryTree(E key) {
        root = new Node(key);
    }

    /**
     * 先序遍历(递归)
     *
     * @param root
     */
    public static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * 先序遍历(非递归)
     * 根左右
     * @param root
     * @return
     */
    public List<Node> preOrderTraversalNR(Node root) {
        List<Node> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            /**
             * 将遍历到的节点放置list中;
             */
            result.add(node);
            /**
             * 先放右节点,然后再放左节点
             */
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


    /**
     * 中序遍历(递归)
     *
     * @param root
     */
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历(非递归)
     * 左根右
     * @param root
     * @return
     */
    public List<Node> inOrderTraversalNR(Node root) {
        ArrayList<Node> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            } else {
                result.add(node);
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return result;
    }

    /**
     * 后序遍历(递归)
     *
     * @param root
     */
    public static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left = new Node(6);
        root.right = new Node(7);
        //     1
        //  2      3
        //4  5   6    7
        System.out.print("二叉树先序遍历结果为: ");
        preOrderTraversal(root);
        System.out.print("\n二叉树中序遍历结果为: ");
        inOrderTraversal(root);
        System.out.print("\n二叉树中序遍历结果为: ");
        postOrderTraversal(root);
    }
}
