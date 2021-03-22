package com.zhangyong.DataStructures.GraphTheory.Basics;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * <p>Description: </p>
 *
 * @author yong.zhang
 * @version 1.0.0
 * @date 2020/5/29 13:25
 */
public class Graph {
    //点
    private int V;
    // 边
    private int E;
    private TreeSet<Integer>[] adj;

    public Graph(String fileName) {
        File file = new File(fileName);
        try (Scanner in = new Scanner(file)) {
            V = in.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new TreeSet[V];
            for (int i = 0; i < V; ++i) {
                adj[i] = new TreeSet<Integer>();
            }
            E = in.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("E must be non-negative");
            }
            for (int i = 0; i < E; ++i) {
                int a = in.nextInt();
                valiateVertex(a);
                int b = in.nextInt();
                valiateVertex(b);
                if (a == b) {
                    throw new IllegalArgumentException("Self Loop is Detected!");
                }
                if (adj[a].contains(b)) {
                    throw new IllegalArgumentException("Parallel Edges are Detected!");
                }
                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void valiateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is invalid");
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public boolean hasEdge(int v, int w) {
        valiateVertex(v);
        valiateVertex(w);
        return adj[v].contains(w);
    }

    public Iterable<Integer> adj(int v) {
        valiateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        valiateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d,E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            for (int w : adj[v]) {
                sb.append(String.format("%d ", w));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph adjSet = new Graph("g.txt");
        System.out.println(adjSet);
    }
}
