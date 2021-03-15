package MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

public class _316 {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        char[] words = s.toCharArray();

        for (int i = 0; i < words.length; ++i) {
            count.put(words[i], count.getOrDefault(words[i], 0) + 1);
        }

        for (int i = 0; i < words.length; ++i) {
            char cur = words[i];
            // 计数-1
            count.put(cur, count.get(cur) - 1);

            if (stack.contains(cur)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > cur) {
                if (count.get(stack.peek()) > 1) {
                    count.put(stack.peek(), count.get(stack.peek()) - 1);
                    stack.pop();
                }
            }

            stack.push(cur);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();


    }
}
