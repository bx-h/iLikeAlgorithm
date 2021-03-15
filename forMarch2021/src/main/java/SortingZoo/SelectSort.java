package SortingZoo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SelectSort {
    public void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[min] > arr[j]) { min = j; }
            }
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
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
