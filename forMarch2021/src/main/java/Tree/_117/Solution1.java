package Tree._117;

import org.junit.Test;
/*
*
*
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* */
public class Solution1 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node lTree = root.left;
        Node rTree = root.right;
        while (lTree != null) {
            if (lTree.next == null) lTree.next = rTree;
            lTree = lTree.right == null ? lTree.left : lTree.right;
            rTree = rTree == null ? null : (rTree.left == null ? rTree.right : rTree.left);
        }
        connect(root.left);
        connect(root.right);

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
