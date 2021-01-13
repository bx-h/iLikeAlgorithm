package Tree._117;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll != null) {
                poll.next = queue.peek();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            else {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return root;
    }

    @Test
    public void test1() {
        Node root = new Node(1);
        root.left = new Node(2);
        Node connect = connect(root);
        showNext(connect);

    }

    @Test
    public void test2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(5);

        Node connect = connect(root);
        showNext(connect);

    }

    @Test
    public void test3() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        root.right.right = new Node(6);
        root.right.right.right = new Node(8);
        Node connect = connect(root);
        showNext(connect);
    }

    public void showNext(Node node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            System.out.println(node.val + "--> " + node.next.val);
        }
        else {
            System.out.println(node.val + "--> null");
        }
        showNext(node.left);
        showNext(node.right);
    }
}
