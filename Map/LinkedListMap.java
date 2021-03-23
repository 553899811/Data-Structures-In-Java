package com.zhangyong.DataStructures.Map;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>

 * @version 1.0.0
 * @date 2018/10/23 7:43
 */
public class LinkedListMap<K, V> implements Map<K, V> {


    private class Node {
        public K key;
        private V value;
        //next指针
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key,V value){
            this(key,value,null);
        }
        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            Node t = new Node(key, value);
            t.next = dummyHead.next;
            dummyHead.next = t;
//            dummyHead.next=new Node(key,value,dummyHead.next);
            ++size;
        } else {
            //覆盖原值;
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead.next;
        while (pre != null) {
            if (pre.key.equals(key)) {
                break;
            }
            pre = pre.next;
        }
        if (pre.next != null) {
            Node next = pre.next;
            pre.next = next.next;
            next.next = null;
            return next.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = value;
    }

    //根据Key值获取Node节点;
    private Node getNode(K key) {
        Node head = dummyHead.next;
        while (head != null) {
            if (head.key.equals(key)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
