package Tree._513;

import Tree.utils.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    int layerhead = 0;
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            layerhead = queue.peek().val;
            while (size-- != 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return layerhead;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(findBottomLeftValue(root));
    }
}
