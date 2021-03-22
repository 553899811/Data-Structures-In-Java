package com.zhangyong.DataStructures.List;

import com.zhangyong.DataStructures.Array.Array;

/**
 * <p>ClassName:  </p>
 * <p>Description: 单向链表</p>
 *  模拟实现
 * @author zhangyong
 * @email littledream1502@gmail.com
 * @version 1.0.0
 * @date 2018/9/3 6:46
 */
public class LinkedList<E> {

    //定义节点内部类
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

    //引入虚拟头节点概念
    //dummyHead -> Node-0 -> Node-1 -> Node-2 -> Node-3 -> Node-4
    //(方便维护头节点添加,删除等操作)
    private static transient Node dummyHead;

    // 链表元素个数
    private int size;

    public LinkedList() {
        //初始化虚拟节点
        dummyHead = new Node();
        this.size = 0;
    }

    //输入一个数组,将其转化为一个链表
    public LinkedList(Array<E> array) {
        if (array.getSize() <= 0) {
            return;
        }
        dummyHead.next = new Node(array.get(0));

        Node move = dummyHead.next;
        //避免数组溢出
        for (int i = 1; i < array.getSize(); i++) {
            E e = array.get(i);
            move.next = new Node(e);
            move = move.next;
        }
        size = array.getSize();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头部添加元素e
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表的index(索引index从0开始计算)位置添加新的元素e
    //TODO 有待用递归实现插入过程;
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败,下标越界");
        }
        Node pre = dummyHead;
        //dummyHead-> Node-0 -> Node-1 -> Node-2 -> Node-3 -> Node-4
        //   index      0         1          2         3         4
        //更新pre节点的移动
        for (int i = 0; i < index; i++) {
                pre = pre.next;
        }
       /* Node<E> node = new Node<>(e);
        node.next = pre.next;
        pre.next = node;*/
       // 先创建一个Node节点,是这个Node节点的Next指针指向pre的next节点(目的在于使后半段链表不会游离失踪,)
        pre.next = new Node(e, pre.next);
        ++size;
    }

    //在链表尾部添加元素E
    public void addLast(E e) {
        add(size, e);
    }

    //从链表中删除第一个元素,并返回该元素值
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素,并返回该元素值
    public E removeLast() {
        return remove(size - 1);
    }

    //从链表中删除元素E e,并返回删除结果
    public boolean removeElement(E e) {
        if (e == null) {
            return false;
        }
        //当前指针指向虚拟节点
        Node pre = this.dummyHead;
        while (pre.next != null) {
            //如果发现存在元素E
            if (pre.next.e.equals(e)) {
                if (pre.next != null) {
                    Node node = pre.next;
                    pre.next = node.next;
                    node.next = null;
                    --size;
                    return true;
                }
            }
            pre = pre.next;
        }
        return false;
    }

    //根据索引值index获取链表第index个元素(index 0-based)
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取元素失败,数组下标越界");
        }
        Node head = dummyHead.next;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return (E) head.e;
    }

    //获取链表第一个元素值
    public E getFirst() {
        return get(0);
    }

    //获取链表最后一个元素值
    public E getLast() {
        return get(size - 1);
    }

    //覆盖索引下标index元素值为E e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("覆盖值失败,数组下标越界");
        }
        Node head = dummyHead.next;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        head.e = e;
    }

    //按照索引删除对应元素值,并返回
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除元素失败,元素下标越界");
        }
        Node head = dummyHead;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        // step[0]
        // dummyHead -> Node-0 -> Node-1 -> Node-2 -> Node-3 -> Node-4
        //      ^          ^
        //      |          |
        //     head  ->   next

        // step[1]
        // dummyHead   Node-0 -> Node-1 -> Node-2 -> Node-3 -> Node-4
        //      ^          ^        ^
        //      |          |        |
        //      |         next      |
        //     head -> -> -> -> -> ->

        // step[2]
        // dummyHead     Node-0   Node-1 -> Node-2 -> Node-3 -> Node-4
        //      ^          ^         ^
        //      |          |         |
        //      |         next->null |
        //     head - - - - - - - -> -

        Node next = head.next;
        head.next = next.next;
        //help gc
        next.next = null;
        --size;
        return (E) next.e;
    }

    //判断元素E e在链表中是否存在
    public boolean contain(E e) {
        Node head = dummyHead.next;
        while (head != null) {
            if (head.e.equals(e)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * @param
     * @auther
     * @desc 翻转链表
     * @date 2019/1/1  15:31
     * @from JDK 1.8
     */
    public static Node reverseLinkedList() {
        Node pre = dummyHead;
        Node current = dummyHead.next;
        Node next = null;
        //[dummyHead(null)]->[head(val)]->[node(val)]->[node(val)]->null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node head = dummyHead.next;
        while (head != null) {
            sb.append(head).append(" -> ");
            head = head.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        reverseLinkedList();
        System.out.println(list.toString());
    }
}