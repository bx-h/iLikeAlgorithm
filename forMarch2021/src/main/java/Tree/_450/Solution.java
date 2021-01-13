package Tree._450;

import org.junit.Test;
import Tree.utils.TreeNode;
import Tree.utils.Util;

public class Solution {
    private TreeNode targetFather = null;
    private boolean targetAtLeft = false;
    private TreeNode newRoot = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = BstFindNode(root, key);
        if (target == null) return null;
        TreeNode newTarget = updateNewTarget(target);
        newRoot = root;
        connectAndUpdateRoot(newTarget);
        return newRoot;
    }

    public TreeNode updateNewTarget(TreeNode oldTarget) {
        TreeNode biggestLeft = oldTarget.left;
        if (biggestLeft == null) {
            return oldTarget.right;
        }

        TreeNode bLPrev = null;
        while (biggestLeft.right != null) {
            bLPrev = biggestLeft;
            biggestLeft = biggestLeft.right;
        }

        biggestLeft.right = oldTarget.right;
        if (bLPrev != null) {
            bLPrev.right = biggestLeft.left;
            biggestLeft.left = oldTarget.left;
        }
        // else { // biggestLeft 就是 oldTarget.left, 它没有右子树

        // }

        return biggestLeft;

    }


    public void connectAndUpdateRoot(TreeNode newTarget) {
        if (targetFather != null) {
            if (targetAtLeft) {
                targetFather.left = newTarget;
            } else {
                targetFather.right = newTarget;
            }
        } else { // oldTarget 就是 root
            this.newRoot = newTarget;
        }
    }

    public TreeNode BstFindNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return root;
        this.targetFather = root;
        if (root.val < key) {
            targetAtLeft = false;
            return BstFindNode(root.right, key);
        } else {
            targetAtLeft = true;
            return BstFindNode(root.left, key);
        }
    }


    @Test
    public void t1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode newTree = deleteNode(root, 1);
        Util.printTree(newTree);
    }
}
