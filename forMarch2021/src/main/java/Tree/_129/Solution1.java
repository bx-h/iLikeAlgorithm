package Tree._129;

import org.junit.Test;

public class Solution1 {
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int tempRes) {
        if (root == null) return;
        tempRes = tempRes * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += tempRes;
        }
        helper(root.left, tempRes);
        helper(root.right, tempRes);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int i = sumNumbers(root);
        System.out.println(i);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        int i = sumNumbers(root);
        System.out.println(i);
    }
}
