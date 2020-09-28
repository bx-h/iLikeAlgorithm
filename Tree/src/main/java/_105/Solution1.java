package _105;

import _94.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



/*
* 根据前序和中序构建树
*
* */

public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList<>(preorder.length);
        List<Integer> inList = new ArrayList<>(inorder.length);
        for (int j : preorder) {
            preList.add(j);
        }
        for (int j : inorder) {
            inList.add(j);
        }
        return build(preList, inList);
    }

    public TreeNode build(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return null;
        }

        if (inorder.size() == 1) {
            return new TreeNode(inorder.get(0));
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int pre:preorder) {
            int i = inorder.indexOf(pre);
            if (i == -1) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                left.add(inorder.get(j));
            }
            for (int j = i + 1; j < inorder.size(); j++) {
                right.add(inorder.get(j));
            }

            TreeNode root = new TreeNode(pre);
            root.left = build(preorder, left);
            root.right = build(preorder, right);
            return root;
        }

        return null;
    }

    @Test
    public void test() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        _102.Solution1 solution = new _102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }
}

