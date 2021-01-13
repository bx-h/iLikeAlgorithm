package Tree.utils;

import java.util.LinkedList;
import java.util.Queue;

public class Util {
    /*
    * 先序遍历打印树
    * */
    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    System.out.print("null ");
                    continue;
                }

                System.out.print(poll.val + " ");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            System.out.println("\n");

        }
    }

}
