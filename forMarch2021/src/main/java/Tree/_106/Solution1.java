package Tree._106;

import Tree._94.TreeNode;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        TreeNode res = null;
        TreeNode father = null;

        while (i != inorder.length) {
            if (inorder[i] == postorder[j]) {
                stack.push(inorder[i]);
                i ++;
                j ++;
            }
            else {
                TreeNode currRoot = new TreeNode(inorder[i]);
                currRoot.left = buildTreeFromStack(stack);
                if (father != null) {
                    father.right = currRoot;
                }
                else {
                    res = currRoot;
                }
                i ++;
                father = currRoot;
            }
        }

        if (!stack.isEmpty()) {
            if (father == null) res = buildTreeFromStack(stack);
            else {
                father.right = buildTreeFromStack(stack);
            }
        }

        return res;

    }

    public TreeNode buildTreeFromStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return null;

        TreeNode res = new TreeNode(stack.pop());
        TreeNode prev = res;
        while (!stack.isEmpty()) {
            prev.left =  new TreeNode(stack.pop());
            prev = prev.left;
        }

        return res;
    }


    @Test
    public void test() {
        int[] postorder = {6,9,15,7,20,3};
        int[] inorder = {6,9,3,15,20,7};
        TreeNode treeNode = buildTree(inorder, postorder);
        Tree._102.Solution1 solution = new Tree._102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }

    @Test
    public void test2() {
        int[] inorder = {3, 20, 15, 7};
        int[] postorder = {7, 15, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        Tree._102.Solution1 solution = new Tree._102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }

    @Test
    public void test3() {
        int[] inorder = {-2, -1};
        int[] postorder = {-2, -1};
        TreeNode treeNode = buildTree(inorder, postorder);
        Tree._102.Solution1 solution = new Tree._102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }
}
