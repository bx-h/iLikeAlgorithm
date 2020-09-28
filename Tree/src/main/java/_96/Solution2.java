package _96;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// Solution1超时，Solution2 改用带记忆的递归。

public class Solution2 {

    Map<Integer, Integer> memory = new HashMap<>();

    public int numTrees(int n) {
        return recur(1, n);
    }

    public int recur(int start, int end) {
        if (memory.containsKey(end - start)) return memory.get(end - start); // 二叉树个数只与节点有关。

        if (start > end) return 1; // 空二叉树也视为一棵树。
        if (start == end) return 1;
        int result = 0;
        for (int i = start; i <= end; i++) {
            int l_num = recur(start, i-1);
            int r_num = recur(i+1, end);
            result += l_num * r_num;
        }
        memory.put(end - start, result);
        return result;
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
