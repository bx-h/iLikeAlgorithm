package SortingZoo;

import org.junit.Test;

public class InsertSort {
    public void sort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                int tmp = arr[i];
                // 寻找合适的插入i的位置。
                int j;
                for (j = i; j >= 1 && arr[j-1] > tmp; j--) {
                    // 所有元素往右移动一个位置。
                    arr[j] = arr[j-1];
                }
                arr[j] = tmp;
            }
        }
    }
    @Test
    public void test1() {
        int[] arr = new int[] {3, 2, 5, 1, 9};
        sort(arr, arr.length);
        for (int e : arr) {
            System.out.printf("%d ", e);
        }
    }
}
