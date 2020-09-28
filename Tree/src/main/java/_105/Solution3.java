package _105;

import _94.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
    private int[] preorder;
    private int[] inorder;
    private int preIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        init(preorder, inorder);
        return helper(0, inorder.length - 1);
    }

    public void init(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.preIndex = 0;
        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
    }

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootval = preorder[preIndex];
        int inIndex = inorderMap.get(rootval);

        TreeNode root = new TreeNode(rootval);
        preIndex ++; // 在递归之前就要更新！！！

        root.left = helper(inLeft, inIndex - 1);
        root.right = helper(inIndex + 1, inRight);


        return root;
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
