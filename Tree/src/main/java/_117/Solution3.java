package _117;

import org.junit.Test;

public class Solution3 {
    private Node nextStart = null;
    private Node last = null;
    public Node connect(Node root) {
        if (root == null) return null;

        Node start = root;
        while (start != null) { // 新的一层
            nextStart = null;
            last = null;

            while (start != null) { // 遍历每一层
                if (start.left != null) {
                    handle(start.left);
                }
                if (start.right != null) {
                    handle(start.right);
                }
                start = start.next;
            }

            start = nextStart;
        }

        return root;
    }

    public void handle(Node node) {
        if (nextStart == null) {
            nextStart = node;
        }
        if (last != null) {
            last.next = node;
        }

        last = node;
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
