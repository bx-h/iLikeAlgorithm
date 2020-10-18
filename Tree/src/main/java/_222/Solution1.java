package _222;

/*
*  完全二叉树的节点个数
*
* 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 失败，写不出来，思路堵塞。。。。
*
* */

import java.util.ArrayList;
import java.util.Stack;

public class Solution1 {
    public int countNodes(TreeNode root) {
        int height = 0;
        int minus = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null) {
            stack.push(root);
            height += 1;
            current = current.right;
        }
        height += 1;
        current = stack.pop();

        while (current.right == null) {
            if (current.left == null) {
                minus += 2;
                current = stack.peek().left;
            } else {
                minus += 1;
            }
        }


    }

    public int calChild(TreeNode root) {
        if (root.left != null && root.right != null) {
            return 2;
        } else if (root.right != null || root.left != null) {
            return 1;
        } else {
            return 0;
        }
    }


}
