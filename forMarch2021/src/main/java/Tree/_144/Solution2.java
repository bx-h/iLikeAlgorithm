package Tree._144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> temp = new Stack<>();
        temp.push(root);
        while (!temp.isEmpty()) {
            TreeNode t = temp.pop();
            if (t != null) {
                if (t.right != null) temp.push(t.right);
                if (t.left != null) temp.push(t.left);
                temp.push(t);
                temp.push(null);
            } else {
                res.add(temp.pop().val);
            }
        }

        return res;
    }
}
