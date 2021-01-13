package Tree._107;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> layer = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.peek() == null) {
                result.add(0, layer);
                queue.poll();
                if (queue.isEmpty()) break;
                queue.offer(null);
                layer = new ArrayList<>();
                continue;
            }
            TreeNode poll = queue.poll();
            layer.add(poll.val);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }

        return result;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right =  new TreeNode(7);
        List<List<Integer>> lists = levelOrderBottom(root);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}