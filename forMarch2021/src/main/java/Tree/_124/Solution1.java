package Tree._124;
/*
* 124. 二叉树中的最大路径和
* 给定一个非空二叉树，返回其最大路径和。
* 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */

import org.junit.Test;

public class Solution1 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;

    }

    public int helper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int[] cases = new int[6];
        int max_r = Integer.MIN_VALUE;
        int left = helper(root.left);
        int right = helper(root.right);
        cases[0] = left == Integer.MIN_VALUE ? Integer.MIN_VALUE : left + root.val;
        cases[1] = right == Integer.MIN_VALUE ? Integer.MIN_VALUE : right + root.val;
        cases[2] = root.val;

        cases[3] = left;
        cases[4] = right;
        cases[5] = (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE) ? Integer.MIN_VALUE : left + right + root.val;
        for (int i = 0; i < 6; ++i) {
            if (cases[i] > max) {
                max = cases[i];
            }
            if (i < 3) {
                if (cases[i] > max_r) {
                    max_r = cases[i];
                }
            }
        }
        return max_r;

    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int i = maxPathSum(root);
        System.out.println(i);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = maxPathSum(root);
        System.out.println(i);
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(-3);
        int i = maxPathSum(root);
        System.out.println(i);
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int i = maxPathSum(root);
        System.out.println(i);
    }
}
