package com.zhangyong.DataStructures.GraphTheory.GraphDFSApplication.MoreAboutConnectedComponents;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

import java.util.ArrayList;

/**
 * <p>ClassName:  </p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author zhangyong
 * @version 1.0.0
 * @date 2020/10/28 22:22
 */
public class GraphCC {

    private Graph G;
    private int[] visited;
    //记录联通分量
    private int cccount = 0;

    public GraphCC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < G.V(); ++i) {
            visited[i] = -1;
        }
        for (int v = 0; v < G.V(); ++v) {

            if (visited[v] == -1) {
            //一个联通分量走完 才会走第二个;
                dfs(v, cccount);
                cccount++;
            }
        }
    }

    private void dfs(int v, int cccount) {
        visited[v] = cccount;
        for (int w : G.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, cccount);
            }
        }
    }

    //连通分量的个数;
    private int count() {
        return cccount;
    }

    //判断定点v和w是否在同一个联通分量中;
    private boolean isConnected(int v, int w) {
        G.valiateVertex(v);
        G.valiateVertex(w);
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] res = new ArrayList[cccount];
        for (int i = 0; i < cccount; ++i) {
            res[i] = new ArrayList<>();
        }
        for (int v = 0; v < G.V(); ++v) {
            //v 所在的联通分量集合 [i] 将v 添加入内;
            res[visited[v]].add(v);
        }
        return res;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphCC graphCC = new GraphCC(g);
        System.out.println(graphCC.count());
        System.out.println(graphCC.isConnected(0, 6));
        System.out.println(graphCC.isConnected(5, 6));
        ArrayList<Integer>[] res = graphCC.components();
        for (int i = 0; i < res.length; ++i) {
            System.out.print(i + " : ");
            for (int w : res[i]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
