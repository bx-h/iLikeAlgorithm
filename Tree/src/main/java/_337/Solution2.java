package _337;

import org.junit.Test;

import java.util.HashMap;

/*
* solution1 存在的问题是：
* 1. 考虑了一种冗余情况：实际上，不可能出现：爷爷不选，父亲不选，最后选孙子的情况。只可能存在：（1）爷爷选，孙子选，父亲不选；（2）父亲选
* 2. 将是否选取当前节点作为函数参数，这样子无法获取当前节点的 的 cost 值，无法进行优化。
*
*
*
*
* */
public class Solution2 {
    private final HashMap<TreeNode, Integer> memory = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memory.containsKey(root)) return memory.get(root);

        int method1 = root.val;
        int method2 = 0;
        if (root.left != null) {
            method1 = method1 + rob(root.left.left) + rob(root.left.right);
            method2 = method2 + rob(root.left);
        }
        if (root.right != null) {
            method1 = method1 + rob(root.right.left) + rob(root.right.right);
            method2 = method2 + rob(root.right);
        }
        int ret = Math.max(method1, method2);
        memory.put(root, ret);
        return ret;
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
