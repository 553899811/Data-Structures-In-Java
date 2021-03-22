package com.zhangyong.DataStructures.Tree.BinaryTree;

import com.zhangyong.DataStructures.Queue.ArrayQueue;
import com.zhangyong.DataStructures.Queue.Queue;
import com.zhangyong.DataStructures.Stack.ArrayStack;
import com.zhangyong.DataStructures.Stack.Stack;

/**
 * <p>ClassName:  </p>
 * <p>Description: 二分搜索树 </p>
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/9/11 8:06
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        //打印根节点及其儿子节点
        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", node.left=" + left.e +
                    ", right=" + right.e +
                    '}';
        }
    }

    //BST根节点
    private Node root;
    //表示存储了多少元素;
    private int size;

    //无参构造器
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加元素
    public void add(E e) {
        root = add(root, e);
    }

    /*public void add(E e) {
        if (root == null) {
            root = new Node(e);
            ++size;
        } else {
            add(root, e);
        }
    }
    //(私有方法)向以node为根的二分搜索树中插入元素e,递归实现;
    private void add(Node node, E e) {
        //元素覆盖
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            //左子树为空的话,直接插入;
            node.left = new Node(e);
            ++size;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            ++size;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }*/
    //向以node为根的二分搜索树中插入元素e,递归实现;
    private Node add(Node node, E e) {
        //递归结束标识
        if (node == null) {
            ++size;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以Node为根的二分搜索树中是否包含元素e,递归算法;
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的前序遍历,递归算法实现
    public void preOrder() {
        preOrder(root);
    }

    //二分搜索树的前序遍历,非递归算法实现
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new ArrayStack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.e + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    //前序遍历以node为根的二分搜索树,递归算法;
    //打印顺序: 根+左+右
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历以node为根节点的二分搜索树,递归算法;
    //打印顺序: 左+根+右
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    //中序遍历二分搜索树,非递归算法;
    //打印顺序: 左+根+右
    public void inOrderNR() {
        Stack<Node> stack = new ArrayStack<Node>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.e + " ");
                node = node.right;
            }
        }
    }

    //后序遍历以node为根节点的二分搜索树,递归算法
    //打印顺序: 左 + 右 + 根
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历:递归
     * @param node
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    //后序遍历以node为根节点的二分搜索树,非递归遍历
    //打印顺序: 左+右+根
    public void postOrderNR() {
        ArrayStack<Node> stack = new ArrayStack<Node>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {

        }
    }
    //二分搜索树层序遍历(BFS,广度优先搜索遍历)
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.println(node.e);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    //寻找二叉搜索树的最小值
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("二叉树为空,无法获取最小值");
        }
        return minimum(root).e;
    }

    //返回以node为根的二分搜索树的最小值的根节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //寻找二叉搜索树的最大值
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("二叉树为空,无法查询最大值");
        }
        return maximum(root).e;
    }

    //返回以node为根的二分搜索树的最大值的根节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //删除掉以Node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根;
    private Node removeMin(Node node) {
        if (node.left == null) {
            //定义临时节点保存右子树
            Node rightNode = node.right;
            // help gc
            node.right = null;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMin() {
        E minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    //删除掉以Node为根的二分搜索树中的最大值
    //返回删除节点后新的二分搜索树的根;
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            // help gc
            node.left = null;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E removeMax() {
        E maximum = maximum();
        root = removeMax(root);
        return maximum;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }
    public Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //s为d的后继节点
            Node s = minimum(node.right);
            s.right = removeMin(node.right);
            s.left = node.left;
            return s;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    //生成以node为根节点,深度为depth的描述二叉树的字符串;
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] nums = new int[]{
                5, 3, 6, 8, 4, 2, 7
        };
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8
        //         /
        //        7
        /////////////////
        for (int num : nums) {
            tree.add(num);
        }
        System.out.print("先序遍历二分搜索树:");
        tree.preOrder();
        System.out.println();
        System.out.println("先序遍历二分搜索树非递归实现:");
        tree.preOrderNR();
        System.out.println();

        System.out.println("中序遍历二分搜索树:");
        tree.inOrder();
        System.out.println();
        System.out.print("中序遍历二分搜索树非递归实现:");
        tree.inOrderNR();
        System.out.println();

        System.out.print("后序遍历二分搜索树:");
        tree.postOrder();
        System.out.println();
        System.out.println("后序遍历二分搜索树非递归实现");
        tree.postOrderNR();
        System.out.println();
    }
}
