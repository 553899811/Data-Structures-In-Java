package com.zhangyong.DataStructures.GraphTheory.GraphDFS.Implementation;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

import java.util.ArrayList;

/**
 * <p>Description: </p>
 * <p>Company: http://www.dmall.com</p>
 *
 * @author yong.zhang@dmall.com
 * @version 1.0.0
 * @date 2020/10/28 15:36
 */
public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        //顶点的个数;
        visited = new boolean[G.V()];
        dfs(0);
    }

    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    private Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.order);
    }
}
