package Tree._112;

import Tree._94.TreeNode;

public class Solution {
    private int sum;
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode root, int accum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (accum + root.val == sum) {
                res = true;
                return;
            }
        }
        helper(root.left, accum + root.val);
        helper(root.right, accum + root.val);
    }

}
