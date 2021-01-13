package Tree._337;

import org.junit.Test;

public class Solution1 {
    public int rob(TreeNode root) {
        return Math.max(pickOrNot(root, true), pickOrNot(root, false));
    }

    public int pickOrNot(TreeNode node, boolean isPick) {
        if (node == null) {
            return 0;
        }
        if (isPick) {
            return Math.max(node.val + pickOrNot(node.left, false) + pickOrNot(node.right, false),
                    pickOrNot(node.left, true) + pickOrNot(node.right, true));
        } else {
          return pickOrNot(node.left, true) + pickOrNot(node.right, true);
        }

    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int rob = rob(root);
        System.out.println(rob);
    }


    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int rob = rob(root);
        System.out.println(rob);
    }
}
