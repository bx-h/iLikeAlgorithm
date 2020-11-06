package _235;

import org.junit.Test;

/*
* 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
public class Solution1 {
    private int key1, key2;
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        key1 = p.val;
        key2 = q.val;
        containsKey(root);
        return result;

    }

    public int containsKey(TreeNode root) {
        if (root == null) return 0;
        int left = containsKey(root.left);
        int right = containsKey(root.right);

        if (root.val == key1 || root.val == key2) {
            if (left + right + 1 == 2) {
                result = root;
                return 0;
            }
            else {
                return left + right + 1;
            }
        } else {
            if (left + right == 2) {
                result = root;
                return 0;
            }
            else {
                return left + right;
            }
        }
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
        TreeNode treeNode = lowestCommonAncestor(root, root.left.right.left, root.right.left);
        System.out.println(treeNode.val);
    }
}
