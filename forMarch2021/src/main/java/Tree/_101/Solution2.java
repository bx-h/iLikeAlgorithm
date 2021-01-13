package Tree._101;

import org.junit.Test;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        boolean re1 = isEqual(left.left, right.right);
        boolean re2 = isEqual(left.right, right.left);
        return re1 && re2;
    }


    @Test
    public void test1() {
        // true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    @Test
    public void test2() {
        // false
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    @Test
    public void test3() {
        // false
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);

        System.out.println(isSymmetric(root));
    }

    @Test
    public void test4() {
        // true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);

        System.out.println(isSymmetric(root));
    }

}