package com.zhangyong.DataStructures.Stack;

import java.util.Random;

/**
 * <p>ClassName:  </p>
 * <p>Description: 测试数组栈和链表栈的性能 </p>
 * @author zhangyong
 * @version 1.0.0
 * @date 2018/8/26 23:05
 */
public class Main {

    private static double testStack(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long end = System.nanoTime();
        return (end - start) / ((1 << 9) * 1.0);
    }
    public static void main(String[] args) {
        int opCount = 10;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayStackTime = testStack(arrayStack, opCount);
        System.out.printf("ArrayStack,time: %12.5f ns\n", arrayStackTime);
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListStackTime = testStack(linkedListStack, opCount);
        System.out.printf("LinkedListStack,time: %12.5f ns\n", linkedListStackTime);
    }
}
