package com.zhangyong.DataStructures.Set;

import com.zhangyong.DataStructures.List.LinkedList;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>

 * @version 1.0.0
 * @date 2018/10/18/018 17:55
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contain(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contain(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
