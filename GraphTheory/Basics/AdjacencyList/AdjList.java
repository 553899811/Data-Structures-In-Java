package com.zhangyong.DataStructures.GraphTheory.Basics.AdjacencyList;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <p>Description: 图论- </p>
 *
 * @version 1.0.0
 * @date 2020/5/28 22:24
 */
public class AdjList {
    private int V;
    private int E;
    //代表每个元素关联其他元素的集合;
    private LinkedList<Integer>[] adj;

    public AdjList(String fileName) {
        File file = new File(fileName);
        try (Scanner in = new Scanner(file)) {
            V = in.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("V must be non-negative");
            }
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i) {
                adj[i] = new LinkedList<>();
            }
            E = in.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("E must be non-negative");
            }
            for (int i = 0; i < E; ++i) {
                int a = in.nextInt();
                validataVertex(a);
                int b = in.nextInt();
                validataVertex(b);
                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validataVertex(int v) {
        if (v < 0 || v > V) {
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
        validataVertex(v);
        validataVertex(w);
        return adj[v].contains(w);
    }

    public int degree(int v) {
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
        AdjList adjList = new AdjList("g.txt");
        System.out.println(adjList);
    }
}
