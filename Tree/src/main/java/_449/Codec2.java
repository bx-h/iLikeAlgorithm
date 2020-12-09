package _449;

import org.junit.Test;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec2 {

    private StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> layerNodes = new LinkedList<>();
        layerNodes.offer(root);
        while (!layerNodes.isEmpty()) {
            TreeNode poll = layerNodes.poll();
            if (poll != null) {
                sb.append(poll.val);
                layerNodes.offer(poll.left);
                layerNodes.offer(poll.right);
            }
            else {
                sb.append("null");
            }
            sb.append(",");

        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        int childrenIndex = 1;
        TreeNode root = "null".equals(split[0]) ? null : new TreeNode(Integer.parseInt(split[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (childrenIndex + 1 < split.length) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }

            poll.left = "null".equals(split[childrenIndex]) ? null : new TreeNode(Integer.parseInt(split[childrenIndex]));
            poll.right = "null".equals(split[childrenIndex + 1]) ? null : new TreeNode(Integer.parseInt(split[childrenIndex + 1]));

            queue.offer(poll.left);
            queue.offer(poll.right);

            childrenIndex += 2;
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
