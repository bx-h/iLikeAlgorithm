package MEITUAN.Main1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] matrix = new int[c][r];

        int tr = 0, tc = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                int cur = sc.nextInt();
                matrix[tr++][tc] = cur;
            }
            tc++;
            tr = 0;
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.print("\n");
        }

    }


}
