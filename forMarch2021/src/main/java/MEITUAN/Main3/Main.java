package MEITUAN.Main3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static TreeMap<Integer, Integer> tm = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k; ++i) {
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = k; i < n; ++i) {
            System.out.println(findMax());
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
            tm.put(arr[i-k], tm.get(arr[i-k]) - 1);
        }
        System.out.println(findMax());
    }

    private static int findMax() {
        final int[] max = {Integer.MIN_VALUE};
        AtomicInteger index = new AtomicInteger();
        tm.entrySet().forEach((e) -> {
            if (e.getValue() > max[0]) {
                max[0] = e.getValue();
                index.set(e.getKey());
            }
        });
        return index.get();
    }


}