package Tree._116;

import org.junit.Test;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class Solution1 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node lTree = root.left;
        Node rTree = root.right;
        while (lTree != null && rTree != null) {
            lTree.next = rTree;
            lTree = lTree.right;
            rTree = rTree.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }

    @Test
    public void test1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

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
