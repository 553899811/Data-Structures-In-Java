package com.zhangyong.DataStructures.Hash;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2020/8/8 9:53
 */
public class HashTable<K, V> implements Serializable {
    private static final long serialVersionUID = 8583894024972515476L;

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        this.size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; ++i) {
            hashtable[i] = new TreeMap<K, V>();
        }
    }

    public HashTable() {
        this(97);
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public static void main(String[] args) {
        System.out.println(0x7fffffff);
    }
}
