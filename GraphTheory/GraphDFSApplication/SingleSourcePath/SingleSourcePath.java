package com.zhangyong.DataStructures.GraphTheory.GraphDFSApplication.SingleSourcePath;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Description: </p>
 *
 * @version 1.0.0
 * @date 2020/10/29 13:28
 */
public class SingleSourcePath {

    private Graph G;
    private boolean[] visited;

    private int s;
    private int[] pre;

    public SingleSourcePath(Graph G, int s) {
        G.valiateVertex(s);
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(s, s);
    }

    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
            }
        }
    }

    /**
     * 单源点
     * 从0出发，看哪些与其相连 ;
     *
     * @param t
     * @return
     */
    private boolean isConnected(int t) {
        G.valiateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> res = new ArrayList<>();
        // 若这个点和源点 直接
        if (!isConnected(t)) {
            return res;
        }

        int cur = t;
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
        SingleSourcePath singleSourcePath = new SingleSourcePath(g, 0);
        System.out.println("0 -> 6 :" + singleSourcePath.path(6));
        System.out.println("0 -> 5 :" + singleSourcePath.path(5));
    }

}
