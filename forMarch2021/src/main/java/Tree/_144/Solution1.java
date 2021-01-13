package Tree._144;

import java.util.ArrayList;
import java.util.List;

/*
*
* 二叉树的前序遍历
*
* */
public class Solution1 {
    private final List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
