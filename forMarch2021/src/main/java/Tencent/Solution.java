package Tencent;

import org.junit.Test;

import java.util.PriorityQueue;

class ListNode {
    ListNode next;
    int val;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private ListNode res = new ListNode();
    PriorityQueue<ListNode> queue = new PriorityQueue<>();
    public ListNode merge(ListNode[] lists) {

        for (ListNode node : lists) {
            ListNode cur = node;
            while (cur != null) {
                queue.add(cur);
                cur = cur.next;
            }
        }

        ListNode cur = res;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }

        return res.next;
    }

}


