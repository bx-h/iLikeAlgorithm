package Tree._95;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return recur(1, n);
    }

    public List<TreeNode> recur(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min == max) {
            res.add(new TreeNode(min));
            return res;
        }

        if (min > max) {
            res.add(null);
            return res;
        }

        for (int i = min; i <= max; ++i) {
            List<TreeNode> left = recur(min, i-1);
            List<TreeNode> right = recur(i+1, max);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }

        }
        return res;
    }

    public void printTree(TreeNode root) {
        if(root == null) {
            System.out.print("--->null");
            return;
        }
        System.out.print("-->" + root.val);
        printTree(root.left);
        printTree(root.right);
    }

    @Test
    public void test() {
        List<TreeNode> res = generateTrees(0);
        for (TreeNode re : res) {
            printTree(re);
            System.out.println("\n");
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}