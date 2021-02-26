package DP;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

public class KMP {
    public int[] prefixFunction(String s) {
        int len = s.length();
        int[] p = new int[len];

        int j = 0;
        for (int i = 1; i < len; ++i) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = p[j-1];
            }

            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }

            p[i] = j;
        }

        return p;
    }

    @Test
    public void test1() {
        String s = "ababaca";
        int[] ints = prefixFunction(s);
        for (int i = 0; i < ints.length; ++i) {
            System.out.printf("%d, ", ints[i]);
        }
    }
}
