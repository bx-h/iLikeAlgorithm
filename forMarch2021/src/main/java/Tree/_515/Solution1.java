package Tree._515;

import Tree.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < length; ++i) {
                TreeNode poll = queue.poll();
                if (poll.val > max) {
                    max = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(max);
        }
        return res;


    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> integers = largestValues(root);
        integers.forEach(System.out::println);
    }
}
