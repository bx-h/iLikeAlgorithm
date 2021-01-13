package Tree._199;

/*
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll == null) continue; // 应该没有必要，但是还是加上去防止人为胡乱操作队列引发错误。

            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }

            if (queue.peek() == null) { // 判断是不是到了该层末尾。
                queue.poll();  // 处理掉 null 值
                result.add(poll.val);
                queue.offer(null);
            }

        }

        return result;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right.right = new TreeNode(2);

        List<Integer> integers = rightSideView(root);
        integers.forEach(System.out::println);
    }
}

