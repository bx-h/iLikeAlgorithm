package Tree._235;

/*
* solution1 没有错误，但是忽略了题目是二叉搜索树这一条件
*
*
* */

import org.junit.Test;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        while (root != null) {
            int rootVal = root.val;
            if (rootVal > pVal && rootVal > qVal) {
                root = root.left;
            }
            else if (rootVal < pVal && rootVal < qVal) {
                root = root.right;
            }
            else {
                break;
            }
        }

        return root;

    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(treeNode.val);
    }
}
