package SortingZoo;

import org.junit.Test;

/**
 * 快排类似先序，归并类似后序。
 */
public class MergeSort {
    private int[] tmp;
    public int[] sort(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) { return; }

        // 先递归处理子区间
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1;
        int cnt = 0;
        // 线性选择小的到tmp数组里
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        // j已经到达尽头，将剩余i补全
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        // i已经到浸透了，将剩余j补全
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }

        // 根据偏移更新nums值。
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }

    @Test
    public void test1() {
        int[] arr = new int[] {3, 2, 5, 1, 9};
        sort(arr);
        for (int e : arr) {
            System.out.printf("%d ", e);
        }
    }
}
