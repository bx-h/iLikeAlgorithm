package Tree._173;

//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
//调用 next() 将返回二叉搜索树中的下一个最小的数。


import java.util.Stack;

public class BSTIterator {
    private final Stack<TreeNode> min = new Stack<>();


    public BSTIterator(TreeNode root) {
        insertLeftHand(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = min.pop();
        insertLeftHand(pop.right);
        return pop.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !min.isEmpty();
    }

    // call when insert left part tree to stack "min"
    public void insertLeftHand(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            min.push(temp);
            temp = temp.left;
        }
    }
}
