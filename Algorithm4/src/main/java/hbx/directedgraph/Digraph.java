package hbx.directedgraph;

import java.util.HashMap;
import java.util.LinkedList;

/*
* 有向图实现。
* 采用的数据结构是 hashmap<Integer, List>
* 也可以采用 List[]
* V是节点数量，E是边的数量
* */

public class Digraph {

    private final int V;
    private int E;
    private HashMap<Integer, LinkedList<Integer>> adj;


    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new HashMap<>();
        for (int v = 0; v < V; ++v) {
            adj.put(v, new LinkedList<>());
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj.get(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Digraph dig = new Digraph(5);
        dig.addEdge(0, 1);
        dig.addEdge(1, 2);
        dig.addEdge(0, 3);
        dig.addEdge(3, 4);
        dig.addEdge(3, 2);

        System.out.println(dig);
    }


}
