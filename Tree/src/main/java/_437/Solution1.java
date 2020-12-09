package _437;

import org.junit.Test;

public class Solution1 {
    private int num = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum, false);

        return num;
    }


    public void helper(TreeNode root, int target, boolean start) {
        if (root == null) return;

        if (target - root.val == 0) {
            num += 1;
        }

        if (!start){
            helper(root.left, target, false);
            helper(root.right, target, false);
        }


        helper(root.left, target-root.val, true);
        helper(root.right, target-root.val, true);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        int i = pathSum(root, 8);
        System.out.println(i);
    }
}
