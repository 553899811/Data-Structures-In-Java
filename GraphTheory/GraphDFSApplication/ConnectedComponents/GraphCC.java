package com.zhangyong.DataStructures.GraphTheory.GraphDFSApplication.ConnectedComponents;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2020/10/28 21:57
 */
public class GraphCC {
    private Graph G;
    private int[] visited;
    private int cccount = 1;

    public GraphCC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; ++i) {
            visited[i] = -1;
        }
        for (int v = 0; v < G.V(); ++v) {
            if (visited[v] == -1) {
                dfs(v, cccount);
                cccount += 1;
            }
        }
    }

    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (int w : G.adj(v)) {
            //同一个连通分量,ccid相同;
            if (visited[w] == -1) {
                dfs(w, ccid);
            }
        }
    }

    //联通分量的个数;
    public int count() {
        // visited[i]代表的是i元素在第几个连通分量中;
        for (int w : visited) {
            System.out.print(w + " ");
        }
        System.out.println();
        return cccount;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphCC graphCC = new GraphCC(g);
        System.out.println(graphCC.count());
    }
}
