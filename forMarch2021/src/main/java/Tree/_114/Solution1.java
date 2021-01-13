package Tree._114;

import org.junit.Test;
import Tree.utils.TreeNode;

/*
*
* 114. 二叉树展开为链表
*
*
* */

public class Solution1 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

//        if (root.left == null && root.right == null) return; // 左 null，右 null
//        else if (root.left == null) return; // 左 null，右 not null
//        if (root.right == null && root.left != null) { // 左 not null，右 null
//            root.right = root.left;
//            root.left = null;
//        }
        if (root.left != null){
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public void showflatten(TreeNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);

        showflatten(root);
    }


}
