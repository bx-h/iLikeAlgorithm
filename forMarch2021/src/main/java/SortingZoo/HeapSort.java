package SortingZoo;

/**
 * Java program for implementation of Heap Sort
 */
public class HeapSort {
    public void sort(int arr[])
    {
        int n = arr.length;

        // 先把数组变为大顶堆
        // 从最后一个非叶子节点开始。由下至上。
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // 将头部节点（最大值）扔去尾部
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 在剩余的数组中（除去尾部节点）继续维护最大堆性质。
            // 此时 arr 数组要处理的范围是[0, i), [i, n)部分已经有序。
            heapify(arr, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
     */
    void heapify(int arr[], int n, int i)
    {
        // Initialize largest as root
        int largest = i;
        // left = 2 * i + 1
        int l = 2 * i + 1;
        // right = 2 * i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // largest指的是下标
            // 受影响的子树才需要递归（左 or 右）
            heapify(arr, n, largest);
        }
    }

    /**
     * A utility function to print array of size n
     */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
