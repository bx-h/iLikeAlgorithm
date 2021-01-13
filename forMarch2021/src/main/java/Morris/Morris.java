package Morris;

import org.junit.Test;
import Tree.utils.TreeNode;

public class Morris {
    public void inorder(TreeNode root) {
         TreeNode cur = root;
         while (cur != null) {
             if (cur.left == null) {
                 operate(cur);
                 cur = cur.right;
             } else {
                 TreeNode mostRight = findMostRightOfLeftTree(cur);
                 if (mostRight.right == null) {
                     // 访问左子树
                     mostRight.right = cur;
                     cur = cur.left;
                 } else {
                     // cur 的左子树已经访问完毕了
                     operate(cur);
                     // 访问右子树
                     mostRight.right = null;
                     cur = cur.right;
                 }
             }
         }
    }

    public void preorder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                operate(cur);
                cur = cur.right;
            } else {
                TreeNode mostRight = findMostRightOfLeftTree(cur);
                if (mostRight.right == null) {
                    operate(cur);
                    // 访问左子树
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    // cur 的左子树已经访问完毕了
                    // 访问右子树
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public TreeNode findMostRightOfLeftTree(TreeNode cur) {
        TreeNode mostRight = cur.left;
        while (mostRight.right != null && mostRight.right != cur) {
            mostRight = mostRight.right;
        }
        return mostRight;
    }

    public void operate(TreeNode node) {
        if (node != null) {
            System.out.printf("node[%d] -> ", node.val);
        }
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Morris morris = new Morris();
        morris.preorder(root);
    }
}
