package Tree._113;

/*
* 频繁创建中间数组十分浪费。
* 因此使用可以避免回溯污染的递归
* 在递归尾部移除所有引用变量的变化
*
* */

import Tree._94.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int remain, List<Integer> res) {
        if (root == null) return;
        if (root.val == remain && root.left == null && root.right == null) {
            res.add(root.val);
            this.result.add(new ArrayList<>(res));
            res.remove(res.size() - 1);
        }
        res.add(root.val);
        helper(root.left, remain - root.val, res);
        helper(root.right, remain - root.val, res);
        res.remove(res.size() - 1);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = pathSum(root, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        List<List<Integer>> lists = pathSum(root, -5);
        lists.forEach(System.out::println);
    }
}
