package com.zhangyong.DataStructures.Array;

/**
 * <p>ClassName:  </p>
 * <p>Description: 动态数组 </p>
 *
 * @author zhangyong
 * @version 1.0.0
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数,传入数组的容量capacity构造array;
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 构造函数
     *
     * @param array
     */
    public Array(E[] array) {
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        size = array.length;
    }

    /**
     * 无参构造器
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中元素个数
     */
    public int size() {
        return getSize();
    }

    /**
     * 获取数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在索引为index的位置插入一个新元素e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组越界");
        }
        //扩容前提: 当动态数组中实际数组长度塞满的时候,随即触发扩容机制
        if (data.length == size) {
            //TODO
            resize(data.length << 1);
        }
        //添加元素的代价就是其余元素的迁移;
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 数组按照指定新的容量扩容
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 在数组尾部添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组头部添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     *    根据索引值获取数组元素值;
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界");
        }
        return data[index];
    }

    /**
     *     获取数组中尾部元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     *     获取数组中头部元素
     */
    public E getFirst() {
        return get(0);
    }


    /**
     *   根据索引覆盖数组中对应旧值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界");
        }
        data[index] = e;
    }

    /**
     *    判断数组中是否包含元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     *   查找数组中元素e所在的位置
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *   根据索引值删除数组中对应下标元素,并返回删除元素值;
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败,数组越界.");
        }
        E e = data[index];
        //被移除位置后面的元素都要向前移动一个位置;
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //TODO 扩容机制
        if (size == data.length >> 2 && data.length >> 1 == 0) {
            resize(data.length >> 1);
        }
        return e;
    }

    /**
     *    从数组中删除第一个元素,并返回元素值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     *     从数组尾部元素,并返回
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     *     从数组中删除元素e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public boolean isLegal(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    public void swap(int i, int j) {
        if (!isLegal(i) || !isLegal(j)) {
            throw new IllegalArgumentException("数组下标不合法");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("数组: 大小 = %d ,capacity = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
