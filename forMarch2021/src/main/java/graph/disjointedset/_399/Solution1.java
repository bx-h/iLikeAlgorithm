package graph.disjointedset._399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsize = equations.size();
        UnionFind unionset = new UnionFind(2 * equationsize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashmap = new HashMap<>(2 * equationsize);
        int id = 0;
        for (int i = 0; i < equationsize; ++i) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashmap.containsKey(var1)) {
                hashmap.put(var1, id);
                id++;
            }
            if (!hashmap.containsKey(var2)) {
                hashmap.put(var2, id);
                id++;
            }
            unionset.union(hashmap.get(var1), hashmap.get(var2), values[i]);
        }

        int querysize = queries.size();
        double[] res = new double[querysize];
        for (int i = 0; i < querysize; ++i) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = hashmap.get(var1);
            Integer id2 = hashmap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionset.isconnected(id1, id2);
            }

        }
        return res;


    }

    private class UnionFind {
        int[] parent;
        double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }


        /**
         * 从根开始由上到下更新节点和权值。
         *
         * @param x
         * @return
         */
        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[x] * weight[origin];
            }

            return parent[x];

        }


        /**
         * @param x     verticle x
         * @param y     verticle y
         * @param value edge weight between x and y
         */
        public void union(int x, int y, double value) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;
            weight[rootx] = weight[y] * value / weight[x];
        }

        public double isconnected(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }


    }
}
