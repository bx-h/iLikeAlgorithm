package Tree._230;
/*
* 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
* 说明:
* 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 进阶：
* 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
* */

import org.junit.Test;

import java.util.Stack;

public class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);

            }
            else {
                result = stack.pop().val;
                if (++count == k) {
                    break;
                }
            }
        }
        return result;

    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int i = kthSmallest(root, 3);
        System.out.println(i);
    }
}
