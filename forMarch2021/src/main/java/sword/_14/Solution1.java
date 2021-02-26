package sword._14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public int cuttingRope(int n) {
        if (n <= 1) return 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(n / 2);
        q.offer(n % 2 == 0 ? (n / 2) : (n / 2 + 1));

        while(!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            // 一层
            for (int i = 0; i < len; ++i) {
                int poll = q.poll();
                temp.add(poll);
                if (poll > 1) {
                    q.offer(poll / 2);
                    q.offer(poll  % 2 == 0 ? (poll / 2) : (poll / 2 + 1));
                }
            }
            res.add(temp);
        }

        int max = 0;
        for (ArrayList<Integer> list : res) {
            Integer product = list.stream().reduce(1, (a, b) -> a * b);
            if (product > max) {
                max = product;
            }
        }
        return max;
    }

    @Test
    public void test1() {
        int res = cuttingRope(2);
        System.out.println(res);
    }
}
