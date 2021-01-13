package Tree._96;

import org.junit.Test;

public class Solution1 {
    public int numTrees(int n) {
        return recur(1, n);
    }

    public int recur(int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        int result = 0;
        for (int i = start; i <= end; i++) {
            int l_num = recur(start, i-1);
            int r_num = recur(i+1, end);
            if (l_num == 0 || r_num ==0) result += Math.max(l_num, r_num);
            else {
                result += l_num * r_num;
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
