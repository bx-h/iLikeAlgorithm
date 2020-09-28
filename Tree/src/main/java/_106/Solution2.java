package _106;

import _94.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] inorder;
    private int[] postorder;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return build(0, inorder.length - 1);
    }

    public TreeNode build(int inLeft, int inRight) {

        if (inLeft > inRight) return null;

        int rootval = postorder[postIndex];
        TreeNode rootNode = new TreeNode(rootval);
        int inIndex= inorderMap.get(rootval);

        postIndex--;

        rootNode.right = build(inIndex + 1, inRight);
        rootNode.left = build(inLeft, inIndex - 1);

        return rootNode;

    }

    @Test
    public void test() {
        int[] postorder = {6,9,15,7,20,3};
        int[] inorder = {6,9,3,15,20,7};
        TreeNode treeNode = buildTree(inorder, postorder);
        _102.Solution1 solution = new _102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }

    @Test
    public void test2() {
        int[] inorder = {3, 20, 15, 7};
        int[] postorder = {7, 15, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        _102.Solution1 solution = new _102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }

    @Test
    public void test3() {
        int[] inorder = {1, 2, 3, 4};
        int[] postorder = {2, 1, 4, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        _102.Solution1 solution = new _102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }
}

