package Tree._101;

import java.util.Stack;

public class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.add(left.left);
            stack.add(right.right);
            stack.add(left.right);
            stack.add(right.left);

        }

        return true;
    }
}
