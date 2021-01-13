package Tree._530;

import Tree.utils.TreeNode;

import java.util.Map;

public class Solution1 {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;

    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = RightestInLeftTree(root);
        TreeNode right = leftestInRightTree(root);

        int leftval = left == null ? Integer.MAX_VALUE: Math.abs(root.val - left.val);
        int rightval = right == null ? Integer.MAX_VALUE : Math.abs(root.val - right.val);
        if (leftval < min) {
            min = leftval;
        }
        if (rightval < min) {
            min = rightval;
        }
        helper(root.left);
        helper(root.right);
    }

    public TreeNode leftestInRightTree(TreeNode root) {
        TreeNode right = root.right;
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;

    }

    public TreeNode RightestInLeftTree(TreeNode root) {
        TreeNode left = root.left;
        if (left == null) {
            return null;
        }
        while (left.right != null) {
            left = left.right;
        }
        return left;

    }
}
