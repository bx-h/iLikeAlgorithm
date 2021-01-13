package graph._547;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        UnionSet unionset = new UnionSet(size);
        for (int row = 0; row < isConnected.length; ++row) {
            for (int column = 0; column < row; ++column) {
                if (isConnected[row][column] == 1) {
                    unionset.union(row, column);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; ++i) {
            set.add(unionset.find(i));
        }
        return set.size();
    }

    private class UnionSet {
        private final int[] parent;

        public UnionSet(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;
        }
    }
}
