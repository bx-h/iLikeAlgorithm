package _94;

import sun.lwawt.macosx.CPlatformEmbeddedFrame;

import java.util.*;


public class Solution1 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = inorderTraversal(root.left);  // 左
        left.add(root.val);  // 中
        List<Integer> right = inorderTraversal(root.right); // 右
        left.addAll(right);
        return left;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop(); // 左
                result.add(cur.val);  // 中
                cur = cur.right;  // 右
            }
        }
        return result;
    }

    enum Color {
        WHITE, BLACK
    }

    public static Map.Entry<Color, TreeNode> createEntry(Color color, TreeNode node) {
        return new AbstractMap.SimpleEntry<>(color, node);
    }

    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Map.Entry<Color, TreeNode>> stack = new Stack<>();
        stack.add(createEntry(Color.WHITE, root));

        while (!stack.isEmpty()) {
            Map.Entry<Color, TreeNode> node = stack.pop();
            if (node.getValue() == null) continue;
            if (node.getKey() == Color.WHITE) {
                stack.add(createEntry(Color.WHITE, node.getValue().right)); // 右
                stack.add(createEntry(Color.WHITE, node.getValue().left)); // 左
                stack.add(createEntry(Color.BLACK, node.getValue()));  // 中
            }
            else {
                res.add(node.getValue().val);
            }
        }
        return res;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        List<Integer> integers = inorderTraversal2(root);
        integers.forEach(System.out::print);
    }
}
