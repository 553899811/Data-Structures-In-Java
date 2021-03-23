package com.zhangyong.DataStructures.Map;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * @version 1.0.0
 * @date 2018/10/18/018 17:56
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
