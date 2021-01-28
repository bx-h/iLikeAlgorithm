package sword._7;

import org.junit.Test;

import java.util.HashMap;

public class Solution {
    private int rootindex = 0;
    private int length;
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> inorderhash;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderhash = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inorderhash.put(inorder[i], i);
        }
        this.length = preorder.length;
        this.inorder = inorder;
        this.preorder = preorder;
        return helper(0, preorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
//        if (rootindex >= length) return null;

        int i = inorderhash.get(preorder[rootindex]);
        TreeNode root = new TreeNode(preorder[rootindex]);
        rootindex++;

        root.left = helper(left, i - 1);
        root.right = helper(i + 1, right);

        return root;

    }

    @Test
    public void test1() {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        boolean[][] table = new boolean[4][5];
        table[0][0] = true;
    }
}
