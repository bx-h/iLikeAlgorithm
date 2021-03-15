package MonotonicStack;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class nextGreaterNum2 {
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 利用取余获得正确的值，模拟环形数组。
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            // 从后到前，后面的无效元素最后会被前面的元素覆盖。
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }

        return res;
    }


    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        System.out.println("hello: " + s);
//        input.close();



        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        

    }
}
