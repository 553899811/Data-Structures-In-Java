package com.zhangyong.DataStructures.GraphTheory.GraphDFS.Improvement;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

import java.util.ArrayList;

/**
 * <p>Description: </p>
 * <p>Company: http://www.dmall.com</p>
 *
 * @author yong.zhang@dmall.com
 * @version 1.0.0
 * @date 2020/10/28 15:56
 */
public class GraphDFS {
    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        post.add(v);
    }

    private Iterable<Integer> pre() {
        return pre;
    }

    private Iterable<Integer> post() {
        return post;
    }

    public static void main(String[] args) {
        Graph G = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(G);
        System.out.println("DFS preOrder : " + graphDFS.pre());
        System.out.println("DFS postOrder :" + graphDFS.post());
    }
}
