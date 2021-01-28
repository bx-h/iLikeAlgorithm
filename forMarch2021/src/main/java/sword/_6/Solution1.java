package sword._6;

import java.util.HashMap;
import java.util.Stack;

public class Solution1 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];

        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }

        return res;
    }
}
