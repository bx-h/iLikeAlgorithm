package _101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* 思路错误、、、
*
* */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        result.forEach(System.out::print);
        System.out.println("\n");

        int length = result.size();

        for (int i = 0, j = length - 1; i + 1 <= j; i++, j--) {
            if (!result.get(i).equals(result.get(j))) {
                return false;
            }
        }

        return true;

    }

    @Test
    public void test1() {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);

        System.out.println(isSymmetric(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);

        System.out.println(isSymmetric(root));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}