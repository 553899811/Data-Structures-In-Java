package com.zhangyong.DataStructures.GraphTheory.GraphDFSApplication.SingleSourcePath;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * <p>Description: </p>
 * <p>Company: http://www.dmall.com</p>
 *
 * @author yong.zhang@dmall.com
 * @version 1.0.0
 * @date 2021/1/2 20:36
 */
public class SingleSourcePath1 {


    private Graph G;
    private boolean[] visited;

    private int s;
    private int d;
    private int[] pre;

    public SingleSourcePath1(Graph G, int s, int d) {
        G.valiateVertex(s);
        G.valiateVertex(d);
        this.G = G;
        this.s = s; //source 起始点
        this.d = d; // distination 终点
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(s, s);
        for (int i = 0; i < visited.length; ++i) {
            System.out.print(visited[i] + " ");
        }
        System.out.println();
    }

    public boolean isConnected() {
        G.valiateVertex(d);
        return visited[d];
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        if (v == d) {
            return true;
        }
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Iterable<Integer> path() {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnected()) {
            return res;
        }
        int cur = d;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        Deque deque=new ArrayDeque();
        SingleSourcePath1 path1 = new SingleSourcePath1(g, 0, 6);
        System.out.println("0--->6: " + path1.path());

        SingleSourcePath1 path2 = new SingleSourcePath1(g, 0, 1);
        System.out.println("0--->1: " + path2.path());
        SingleSourcePath1 path3 = new SingleSourcePath1(g, 0, 5);
        System.out.println("0--->5: " + path3.path());
    }
}
