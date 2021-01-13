package Tree._110;

import Tree._94.TreeNode;
import org.junit.Test;

public class solution1 {
    public boolean isBalanced(TreeNode root) {
        int helper = helper(root);
        return helper != -1;

    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        if (l != -1 && r != -1) {
            if (Math.abs(l - r) > 1) {
                return -1;
            }
            return Math.max(l, r) + 1;
        }
        else {
            return -1;
        }

    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }

}
