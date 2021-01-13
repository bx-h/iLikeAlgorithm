package hbx.directedgraph;

import java.util.ArrayList;
import java.util.Arrays;

/** 根据提供的 sources 点，建立 marked 数组，表示从 sources 可以到达的点
 * @author BaixiHwang(huangbx666 @ gmail.com)
 * @version 0.1.0
 * @create 2021-01-13 22:00
 * @since 0.1.0
 *
 **/
public class DirectedDFS {
    private boolean[] marked;

    /**
     * find points can be reached from point s
     * @param G digraph
     * @param s start point
     */
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * find points can be reached from points sources
     * @param G digraph
     * @param sources start points
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s:sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    /**
     * do the dfs search from verticle v
     * @param G digraph
     * @param v start point to apply dfs
     */
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * get the result: whether v is reachable from sources or s which offered in constructor
     * @param v point to be test whether reachable
     * @return true or false
     */
    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(3, 4);
        G.addEdge(3, 0);
        System.out.println(G);
        ArrayList<Integer> sources = new ArrayList<>();
        sources.add(0);
        DirectedDFS reachable = new DirectedDFS(G, sources);

        System.out.println("The following can be reached: ");
        for (int v = 0; v < G.V(); v++) {
            if (reachable.marked(v)) {
                System.out.print(v + " ");
            }
        }
    }
}
