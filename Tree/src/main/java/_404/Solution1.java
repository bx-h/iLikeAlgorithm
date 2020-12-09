package _404;

import org.junit.Test;

public class Solution1 {
    private int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return res;
    }

    public void helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                res += root.val;
            }
        }
        helper(root.left, true);
        helper(root.right, false);
    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = sumOfLeftLeaves(root);
        System.out.println(i);
    }
}
