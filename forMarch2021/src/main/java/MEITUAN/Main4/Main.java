package MEITUAN.Main4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer>[] neighbor;
    private static boolean[] checked;
    private static int[] height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        height = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            height[i] = sc.nextInt();
        }

        neighbor = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            neighbor[i] = new ArrayList<>();
        }
        checked = new boolean[n + 1];

        for (int i = 0; i < m; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            neighbor[u].add(v);
        }

        int max = 0;

        for (int i = 1; i < n + 1; ++i) {
            int res = findpath(i);
            if (res > max) {
                max = res;
            }
        }

        System.out.println(max);

    }

    private static int findpath(int start) {
        int max = 0;
        ArrayList<Integer> neighborOfI = neighbor[start];
        for (Integer e : neighborOfI) {

            if (!checked[e] && height[e] < height[start]) {
                checked[e] = true;
                int res = findpath(e) + 1;
                if (max < res) {max = res;}
                checked[e] = false;
            }
        }

        return max;
    }
}