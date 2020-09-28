package _98;

import org.junit.Test;

import java.util.ArrayList;

public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        boolean left = isValid(root.left, min, (long) root.val);
        boolean right = isValid(root.right, (long) root.val, max);

        return left && right;

    }

    @Test
    public void test1() {
        // true
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test2() {
        // false
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test3() {
        // false
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test4() {
        // false
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test5() {
        // true
        TreeNode root = null;
        System.out.println(isValidBST(root));
    }

    @Test
    public void test6() {
        // false
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test7() {
        // false
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test8() {
        // true
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test9() {
        // false
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test10() {
        // true
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(Integer.MIN_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(isValidBST(root));
    }

    @Test
    public void test11() {
        // true
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        root.right.left = new TreeNode(Integer.MIN_VALUE);
        root.right.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(isValidBST(root));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
