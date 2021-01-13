package Tree._501;

import Tree.utils.TreeNode;

import java.util.ArrayList;

public class Solution {
    int count = 0;
    int maxcount = 0;
    int prev = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        int[] mode = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            mode[i] = ans.get(i);
        }
        return mode;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (root.val == prev) {
            count += 1;
        } else {
            prev = root.val;
            count = 1;
        }
        if (count == maxcount) {
            ans.add(root.val);
        } else if (count > maxcount) {
            ans.clear();
            maxcount = count;
            ans.add(root.val);
        }
        helper(root.right);

    }
}
