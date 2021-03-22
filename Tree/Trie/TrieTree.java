package com.zhangyong.DataStructures.Tree.Trie;

import java.util.TreeMap;

/**
 * <p>ClassName: 字典树 </p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2019/12/18 22:28
 */
public class TrieTree {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private TrieTree() {
        root = new Node();
        size = 0;
    }

    private Node root;
    private int size;

    /**
     * 向字典树中添加单词
     *
     * @param word
     */
    private void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word 是否在字典树中;
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀;
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
