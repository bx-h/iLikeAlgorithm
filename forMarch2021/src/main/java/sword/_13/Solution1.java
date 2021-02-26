package sword._13;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            res += 1;
            visited[i][j] = true;
            if (i + 1 < m && !visited[i + 1][j] && digitSum(i + 1, j) <= k) {
                queue.offer(new int[]{i + 1, j});
            }
            if (j + 1 < n && !visited[i][j + 1] && digitSum(i, j + 1) <= k) {
                queue.offer(new int[]{i, j + 1});
            }
        }

        return res;
    }

    public int digitSum(int i, int j) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i = i / 10;
        }

        while (j != 0) {
            res += j % 10;
            j = j / 10;
        }

        return res;
    }


    @Test
    public void test1() {
        movingCount(1, 2, 1);
    }



    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            int res = 0;
            Queue<int[]> queue= new LinkedList<int[]>();
            queue.add(new int[] { 0, 0, 0, 0 });
            while(queue.size() > 0) {
                int[] x = queue.poll();
                int i = x[0], j = x[1], si = x[2], sj = x[3];
                if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
                visited[i][j] = true;
                res ++;
                queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
                queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
            }
            return res;
        }
    }
}
