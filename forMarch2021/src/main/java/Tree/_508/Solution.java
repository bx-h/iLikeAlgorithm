package Tree._508;

import Tree.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> ans = new HashMap<>();
    ArrayList<Integer> res = new ArrayList<>();

    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        findsum(root);
        ans.forEach((k, v)->{
            if (v > max) {
                res.clear();
                res.add(k);
                max = v;
            } else if (v == max) {
                res.add(k);
            }
        });

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }

    public int findsum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftsum = findsum(root.left);
        int rightsum = findsum(root.right);
        int rootsum = root.val + leftsum + rightsum;
        ans.merge(rootsum, 1, Integer::sum);
        return rootsum;
    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        int[]res = findFrequentTreeSum(root);
        for (int re : res) {
            System.out.printf("%d ", re);
        }
    }
}
