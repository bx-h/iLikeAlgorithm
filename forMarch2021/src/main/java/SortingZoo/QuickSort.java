package SortingZoo;

import org.junit.Test;

public class QuickSort {
    public void sort(int[] arr, int left, int right) {
        // left 和 right 都是合法下标
        // left > right，不需要排；left = right，只有一个元素，也不需要排。
        if (left >= right) { return; }
        int i = left, j = right;
        // i = j 时停止
        while (i < j) {
            // = 的时候哨兵不能停
            // 最终结果是：[<= i] i [>= i]
            // 必须先操作 j，假如先操作i，可能最后i停在了大于left的点的位置，交换之后就出错了。
            while (i < j && arr[j] >= arr[left]) {j --;}
            while (i < j && arr[i] <= arr[left]) {i ++;}
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, left);
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test1() {
        int[] arr = new int[] {3, 2, 5, 1, 9};
        sort(arr, 0, arr.length - 1);
        for (int e : arr) {
            System.out.printf("%d ", e);
        }
    }
}
