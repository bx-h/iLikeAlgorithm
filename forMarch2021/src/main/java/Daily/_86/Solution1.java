package Daily._86;
/*
* 分割链表
* */

import Daily.utils.ListNode;
import org.junit.Test;

public class Solution1 {
    ListNode base = null;
    ListNode head = null;
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        this.head = head;
        ListNode cur = head.next;
        ListNode prev = head;
        if (head.val < x) {
            base = head;
            while (base.next != null && base.next.val < x) {
                base = base.next;
            }
            cur = base.next;
            prev = base;
        }

        while (cur != null) {
            if (cur.val < x) {
                ListNode temp = cur.next;
                operate(cur, prev);
                cur = temp;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return this.head;
    }

    public void operate(ListNode cur, ListNode prev) {
        prev.next = cur.next;
        if (base == null) {
            cur.next = head;
            head = cur;
        } else {
            cur.next = base.next;
            base.next = cur;
        }
        base = cur;
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
    }

    @Test
    public void test1() {
        ListNode head = ListNode.buildListFromArray(new int[]{1, 4, 3, 2, 5, 2});
        ListNode newhead = partition(head, 3);
        printLinkedList(newhead);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.buildListFromArray(new int[]{1,2,3});
        ListNode newhead = partition(head, 4);
        printLinkedList(newhead);
    }
}
