package com.zhangyong.DataStructures.GraphTheory.GraphDFSApplication.Cycle;

import com.zhangyong.DataStructures.GraphTheory.Basics.Graph;

/**
 * <p>Description: 环检测问题 </p>
 *
 * @version 1.0.0
 * @date 2021/1/3 19:10
 */
public class CycleDetection {
    private Graph G;
    private boolean[] visited;

    /**
     * 是否有环;
     */
    private boolean hasCycle = false;


    public CycleDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                //如果存在环;
                if (dfs(v, v)) {

                }
            }
        }
    }

    //从顶点V开始，判断图中是否有环;
    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                //
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph G = new Graph("g.txt");
        CycleDetection cd = new CycleDetection(G);
        System.out.println(cd.hasCycle);
    }
}
