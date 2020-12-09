package _449;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 递归法
*
*
* */
public class Codec {
    // Encodes a tree to a single string.

    private final StringBuilder sb = new StringBuilder();
    private Queue<String> queue;

    private void helper(TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        helper(root.left);
        helper(root.right);
    }

    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        queue = new LinkedList<>(Arrays.asList(split));
        return dehelper(queue);
    }

    private TreeNode dehelper(Queue<String> queue) {
        String s = queue.poll();
        TreeNode root;

        if (s == null) return null;

        if (!"null".equals(s)) {
            root = new TreeNode(Integer.parseInt(s));
            root.left = dehelper(queue);
            root.right = dehelper(queue);
        } else {
            root = null;
        }

        return root;

    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        utils.Util.printTree(deserialize);

    }
}
