package Tree._297;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

// 广度遍历法

public class Answer2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                sb.append("null");
            } else {
                sb.append(String.valueOf(poll.val));
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }
        return sb + "]";

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.replace("[", "").replace("]","").split(",");
        Queue<TreeNode> parent = new LinkedList<>();
        int childIndex = 1;
        TreeNode root = null;
        if (!nodes[0].equals("null")) {
            root = new TreeNode(Integer.parseInt(nodes[0]));
        }
        parent.offer(root);

        while (childIndex <= nodes.length - 1) {
            TreeNode father = parent.poll();
            if (father != null) {
                if (!nodes[childIndex].equals("null")) {
                    father.left = new TreeNode(Integer.parseInt(nodes[childIndex]));
                    parent.offer(father.left);
                }
                if (!nodes[childIndex + 1].equals("null")) {
                    father.right = new TreeNode(Integer.parseInt(nodes[childIndex + 1]));
                    parent.offer(father.right);
                }
            }
            childIndex += 2;
        }
        return root;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialize = serialize(root);
        TreeNode deserialize = deserialize(serialize);

        System.out.println(serialize);

        printTree(deserialize);
    }

    public void printTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

}
