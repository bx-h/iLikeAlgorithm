package sword._41;

import org.junit.Test;

import java.util.*;

public class Solution {
    Queue<Integer> A, B;

    public Solution() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    @Test
    public void findMedian() {
        int [] a = new int[]{1, 2, 3};
        Arrays.stream(a).max().getAsInt();
        HashMap<Character, Integer> map = new HashMap<>();

        char[][] board = new char[2][3];
        String s = new String(board[1]);
        for (int i = 0; i < board.length; ++i) {
            Arrays.fill(board[i], '.');
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println("");
        }

        
    }
}
