package _222;

public class Solution2 {
    public int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level += 1;
            root = root.left;
        }
        return level;
    }

    public int countNode(TreeNode root) {
        if (root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNode(root.right) + (1 << left);
        } else {
            return countNode(root.left) + (1 << right);
        }

    }
}
