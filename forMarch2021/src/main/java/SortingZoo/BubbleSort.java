package SortingZoo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort {
    public void sort(int[] arr, int n) {
        // i逐步增加定义j的右边界
        for (int i = 0; i < n - 1; ++i) {
            // j遍历进行相邻元素交换
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
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
