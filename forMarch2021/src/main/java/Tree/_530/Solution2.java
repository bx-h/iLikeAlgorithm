package Tree._530;

import Tree.utils.TreeNode;

import java.util.Map;

public class Solution2 {
    int pre = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        dfs(root.left);
        int diff = Math.abs(pre - root.val);
        if (diff < min) {
            min = diff;
        }
        pre = root.val;
        dfs(root.right);
    }
}
