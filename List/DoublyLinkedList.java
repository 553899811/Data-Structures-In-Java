package com.zhangyong.DataStructures.List;

/**
 * <p>Description: 双向链表</p>
 *
 * @version 1.0.0
 * @date 2020/4/19 13:26
 */
public class DoublyLinkedList<E> {

    private static class Node<E> {
        public E e;
        private Node pre, next;

        Node() {
            this.e = null;
            this.pre = null;
            this.next = null;
        }
    }
}
