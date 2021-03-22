package com.zhangyong.DataStructures.Stack;

import com.zhangyong.DataStructures.List.LinkedList;

/**
 * <p>ClassName:  </p>
 * <p>Description: 链表模拟栈</p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/9/4 7:15
 */
public class LinkedListStack<E> implements Stack<E> {

    //
    private LinkedList<E> list;


    public LinkedListStack() {
        list = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //链表头代表栈顶
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack : top ");
        sb.append(list);
        return sb.toString();
    }

    /**
     * @param args
     * @auther zhangyong@shopin.cn
     * @desc Stack : top 0 -> NULL
     * Stack : top 1 -> 0 -> NULL
     * Stack : top 2 -> 1 -> 0 -> NULL
     * Stack : top 3 -> 2 -> 1 -> 0 -> NULL
     * Stack : top 4 -> 3 -> 2 -> 1 -> 0 -> NULL
     * Stack : top 3 -> 2 -> 1 -> 0 -> NULL
     * @date 2018/9/4  7:30
     * @from JDK 1.8
     */
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
