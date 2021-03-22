package com.zhangyong.DataStructures.GraphTheory.Basics.AdjacencyMatrix;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>Description: 邻接矩阵</p>
 *
 * @author yong.zhang
 * @version 1.0.0
 * @date 2020/4/29 22:48
 */
public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;


    public AdjMatrix(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            adj = new int[V][V];
            E = scanner.nextInt();
            for (int i = 0; i < E; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断v 和w 是否相连
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    private void validateVertex(int v) {
        if (v < 0 || v > V) {
            //参数非法;
            throw new IllegalArgumentException("vertex" + v + " is valid");
        }
    }

    public ArrayList<Integer> adj(int v) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public int degree(int v) {
        return adj(v).size();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d,E= %d\n", V, E));
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                sb.append(String.format("%d", adj[i][j]));
            }
            sb.append('\n');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }
}
