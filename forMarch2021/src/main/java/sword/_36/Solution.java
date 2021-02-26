package sword._36;


import org.junit.Test;

import java.util.Stack;

class Solution {
    Node leftest, rightest;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        leftest = root;
        rightest = root;
        Stack<Node> stack = new Stack<>();
        while (leftest.left != null) {
            leftest = leftest.left;
        }
        while (rightest.right != null) {
            rightest = rightest.right;
        }
        helper(root, stack);
        if (leftest != rightest) {
            leftest.left = rightest;
            rightest.right = leftest;
        }

        return leftest;


    }

    public void helper(Node root, Stack<Node> stack) {
        stack.push(root);
        if (root == null) return;
        if (root.left != null && stack.search(root.left) == -1) {
            Node Left = root.left;
            Node LTrightmost = root.left;
            while(LTrightmost.right != null) {
                LTrightmost = LTrightmost.right;
            }
            root.left = LTrightmost;
            LTrightmost.right = root;
            System.out.printf("%d <-l-> %d\n", LTrightmost.val, root.val);
            helper(Left, stack);
        }
        if (root.right != null && stack.search(root.right) == -1) {
            Node Right = root.right;
            Node RTleftmost = root.right;
            while(RTleftmost.left != null) {
                RTleftmost = RTleftmost.left;
            }
            root.right = RTleftmost;
            RTleftmost.left = root;
            System.out.printf("%d <-r-> %d\n", RTleftmost.val, root.val);
            helper(Right, stack);
        }
        stack.pop();
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Solution sol = new Solution();
        Node node = sol.treeToDoublyList(root);
    }
}

