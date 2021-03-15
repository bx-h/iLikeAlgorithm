package ALIBABA;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] table = new int[n * m];
        int ti = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                table[ti++] = i * j;
            }
        }
        Arrays.sort(table);
        System.out.println(table[k-1]);
    }
}
