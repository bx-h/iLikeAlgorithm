package Other;

import org.junit.Test;

import java.util.Arrays;

/**
 * 字符串实现乘法
 */
public class BigMultiply {
    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int m = num1.length(), n = num2.length();
        int[] res  = new int[m + n];
        Arrays.fill(res, 0);

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (nums1[i] - '0') * (nums2[j] - '0');
                // p1, p2 为 mul 将要填入的位置
                int p1 = i + j, p2 = i + j + 1;
                // 怕p2到p1有进位，先拿出来加一下
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        // 消除前导0
        int i = 0;
        while (i < res.length && res[i] == 0) {i++;}
        StringBuilder sb = new StringBuilder();
        for (; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test1() {
        System.out.println(multiply("132", "64"));
    }
}
