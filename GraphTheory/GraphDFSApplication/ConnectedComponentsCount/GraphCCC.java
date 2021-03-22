package com.zhangyong.DataStructures.GraphTheory.GraphDFSApplication.ConnectedComponentsCount;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

/**
 * <p>Description: 求无向图 联通分量个数 </p>
 *
 * @version 1.0.0
 * @date 2020/9/9 23:24
 */
public class GraphCCC {
    private Graph graph;
    private boolean[] visited;
    //联通分量个数
    private int connectedComponentsCount = 0;

    public GraphCCC(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); ++i) {
            if (!visited[i]) {
                dfs(i);
                connectedComponentsCount += 1;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }


    private int count() {
        return connectedComponentsCount;
    }

    public static void main(String[] args) {
        Graph G = new Graph("g.txt");
        GraphCCC graphCCC = new GraphCCC(G);
        System.out.println(graphCCC.count());
    }
}
