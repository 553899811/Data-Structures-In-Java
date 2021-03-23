package com.zhangyong.DataStructures.Set;

import com.zhangyong.DataStructures.Tree.BinaryTree.BinarySearchTree;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>

 * @version 1.0.0
 * @date 2018/10/17/017 13:47
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    //构造函数
    public BinarySearchTreeSet() {
        bst = new BinarySearchTree<E>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
