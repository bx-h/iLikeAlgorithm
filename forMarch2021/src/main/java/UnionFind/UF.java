package UnionFind;


public class UF {
    /**
     * 连通分量个数
     */
    private int count;
    /**
     * 父亲
     */
    private int[] fa;
    /**
     * 每个树的节点数量
     */
    private int[] size;

    public UF() {
    }

    public UF(int n) {
        this.count = n;
        fa = new int[n];
        size = new int[n];
        // init case, 每个人的父亲是自己
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        // x 与 y 所在家族合并
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        // 小树接到大树上
        if (size[rootX] > size[rootY]) {
            fa[rootY] = rootX;
            size[rootX] += size[rootY];
        } else {
            fa[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        // 连通分量-1
        count--;
    }

    public boolean connected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    private int find(int x) {
        while (fa[x] != x) {
            // 把爷爷当爹
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }
}
