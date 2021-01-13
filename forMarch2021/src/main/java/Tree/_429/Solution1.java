package Tree._429;

import org.junit.Test;

import java.util.*;

public class Solution1 {
    Queue<Node> queue = new LinkedList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int len = queue.size();
            while (len != 0) {
                Node current = queue.poll();
                if (current != null) {
                    layer.add(current.val);
                    for(Node child : current.children) {
                        queue.offer(child);
                    }
                }
                len--;
            }
            res.add(layer);
        }
        return res;
    }


    @Test
    public void test1() {
        String[] a = {"a", "b", "c"};
        System.out.println(a);
    }

}
