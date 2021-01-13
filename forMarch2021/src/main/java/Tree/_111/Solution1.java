package Tree._111;

import Tree._94.TreeNode;
import org.junit.Test;

public class Solution1 {
    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return min;
    }

    public void helper(TreeNode root, int acculate) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (acculate + 1 < min) {
                min = acculate + 1;
            }
        } else {
            helper(root.left, acculate + 1);
            helper(root.right, acculate + 1);
        }
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(minDepth(root));
    }
}
