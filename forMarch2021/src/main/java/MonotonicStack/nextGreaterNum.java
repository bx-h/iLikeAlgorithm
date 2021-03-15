package MonotonicStack;

import java.util.Stack;

public class nextGreaterNum {
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            while(!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();

            s.push(nums[i]);
        }
        return res;
    }
}
