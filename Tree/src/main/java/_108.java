import _94.TreeNode;
import org.junit.Test;

import java.util.List;

public class _108 {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left ,int right) {
        if (left > right) return null;
        int rootIndex = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(left, rootIndex - 1);
        root.right = helper(rootIndex + 1, right);

        return root;
    }

    @Test
    public void test1() {
        int[] array = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(array);

        _102.Solution1 solution = new _102.Solution1();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.print("\n");
        }
    }
}
