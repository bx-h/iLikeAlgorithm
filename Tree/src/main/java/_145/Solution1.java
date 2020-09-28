package _145;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return output;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> integers = postorderTraversal(root);
        integers.forEach(System.out::print);

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/*

    中序遍历： 4,2,5,1,3

             1
            / \
           2   3
          / \
         4   5

     递归思路：r(1) -> r(2)  ->  r(4)  ->  使用4
               |       |
             使用1    使用2
               |       |
             r(3)    r(5)
               |       |
             使用3    使用5

stack：栈按 root -> left

                                       |   |
                              |   |    |   |
                              |   |    |   |   |   |
                              |   |    |   |   |   |           |   |
                     |   |    |   |    |   |   |   |   |   |   |   |
                     |   |    | 4 |    |   |   |   |   |   |   |   |   |   |
                     | 2 |    | 2 |    | 2 |   | 5 |   |   |   |   |   |   |
            | 1 |    | 1 |    | 1 |    | 1 |   | 1 |   | 1 |   | 3 |   |   |
            |___|    |___|    |___|    |___|   |___|   |___|   |___|   |___|


output: 若上述进栈操作暂停，stack 弹出一个（最顶层）进入 output，切换为该元素的右子树继续尝试进栈。

                                       |   |
                              |   |    |   |
                              |   |    |   |   |   |
                              |   |    |   |   |   |           |   |   | 3 |
                     |   |    |   |    |   |   |   |   |   |   | 1 |   | 1 |
                     |   |    |   |    |   |   |   |   | 5 |   | 5 |   | 5 |
                     |   |    |   |    | 2 |   | 2 |   | 2 |   | 2 |   | 2 |
            |   |    |   |    | 4 |    | 4 |   | 4 |   | 4 |   | 4 |   | 4 |
            |___|    |___|    |___|    |___|   |___|   |___|   |___|   |___|



 */