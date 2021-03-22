package com.zhangyong.DataStructures.Queue;

/**
 * <p>ClassName:  </p>
 * <p>Description: 用链表实现队列</p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/9/5 8:04
 */
public class LinkedListQueue<E> implements Queue<E> {

    //定义链表节点
    private static class Node<E> {
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
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //入队操作
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            //在尾部添加元素
            tail.next = new Node(e);
            //更新尾部指针指向
            tail = tail.next;
        }
        ++size;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,无法出队");
        }
        Node node = this.head;
        head = head.next;
        node.next = null;
        if (head == null) {
            tail = null;
        }
        --size;
        return (E) node.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空,无法出队");
        }
        return (E) head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue: front ");
        Node cur = this.head;
        while (cur != null) {
            sb.append(cur + " -> ");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
