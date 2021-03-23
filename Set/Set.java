package com.zhangyong.DataStructures.Set;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * @version 1.0.0
 * @date 2018/10/17/017 13:46
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
