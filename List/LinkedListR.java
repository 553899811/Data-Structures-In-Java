package com.zhangyong.DataStructures.List;


/**
 * <p>ClassName:  </p>
 * <p>Description: 递归方式实现链表</p>
 * 递归实现
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/9/17/017 12:30
 */
public class LinkedListR<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    //在链表的递归实现中,我们不使用虚拟头节点;
    private Node head;
    private int size;

    public LinkedListR() {
        head = null;
        size = 0;
    }

    //获取链表元素个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的index(based-0)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加元素失败,数组越界");
        }
        head = add(head, index, e);
        ++size;
    }

    //在以Node为头结点的链表的index位置上插入元素,递归实现;
    public Node add(Node node, int index, E e) {
        if (index == 0) {
            //初创链表头节点
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    //链表头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //链表尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //根据索引位置获取元素;
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("获取元素失败,数组下标越界");
        }
        return get(head, index);
    }

    //在以node为头节点的链表中,找到第index个元素;
    public E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    //获取链表头部元素
    public E getFirst() {
        return get(0);
    }

    //获取链表尾部元素
    public E getLast() {
        return get(size - 1);
    }

    //更新下标索引更新链表元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("更新失败,数组下标越界");
        }
        set(head, index, e);
    }

    //修改以node为头节点的链表中,以index(0-based)个位置的元素为e,递归实现;
    public void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    //判断链表中是否含有元素e
    public boolean contains(E e) {
        return contains(head, e);
    }

    //以node为头节点
    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }
    static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    //根据索引,从链表中删除index(0-based)位置的元素,并返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
           throw new IllegalArgumentException("删除失败,索引下标越界");
        }
        Pair<Node, E> res = remove(head, index);
        --size;
        head = res.getKey();
        return res.getValue();
    }


    //利用index的递归迭代实现对链表的遍历;
    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) {
            //将node的next部分返回,跳过node节点;
            return new Pair<Node, E>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair(node, res.getValue());
    }

    //从链表中删除第一个元素,返回删除的元素;
    public E removeFirstList() {
        return remove(0);
    }

    //从链表中删除尾部元素,并返回删除的元素;
    public E removeLast() {
        return remove(size - 1);
    }

    //从链表中删除元素e
    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    //从以node为头节点饿链表中,删除元素e,递归算法实现;
    public Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.equals(e)) {
            size--;
            //将当前要被删除的节点跳过;
            return node.next;
        }
        node.next = removeElement(node.next, e);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "  -->  ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListR<Integer> list = new LinkedListR<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        while (!list.isEmpty()) {
            System.out.println("removed:" + list.removeLast());
        }
    }
}
