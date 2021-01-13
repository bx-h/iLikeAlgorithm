package Tree._105;

/*
* Solution1 复杂度太高，原因可能出现在频繁的进行数组的拷贝上。
* 因此接下来这种方法，通过传递下标的方式，省去递归过程中数组的拷贝。
* 并且在寻找 root 的过程中，采用 hashmap 的方法来节省时间，
*
* */

import Tree._94.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        prepare(preorder, inorder);
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {

        if (inLeft > inRight) return null;
        if (inLeft == inRight) return new TreeNode(inorder[inLeft]);

        int root = preorder[preLeft];
        TreeNode rootNode = new TreeNode(root);
        int rootIndex = inorderMap.get(root);
        int leftTreeLength = rootIndex - inLeft;
        rootNode.left = build(preorder, inorder, preLeft + 1, preLeft + leftTreeLength, inLeft, rootIndex - 1);
        rootNode.right = build(preorder, inorder, preLeft + leftTreeLength + 1, preRight, rootIndex + 1, inRight);

        return rootNode;

    }

    public void prepare(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            inorderMap.put(inorder[i], i);
        }
    }

    @Test
    public void test() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        Tree._102.Solution1 solution = new Tree._102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }
}

