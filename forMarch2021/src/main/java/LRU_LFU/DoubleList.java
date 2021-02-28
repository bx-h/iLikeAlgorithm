package LRU_LFU;

public class DoubleList {
    private Node head, tail;
    private int size;

    /**
     * 构造函数，head和tail是虚节点，无意义
     */
    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 在链表尾部添加节点 x，时间 O(1)
     * @param x
     */
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    /**
     * 删除链表中的 x 节点（x 一定存在）
     * 由于是双链表且给的是目标 Node 节点，时间 O(1)
     * @param x
     */
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    /**
     * 删除第一个节点
     * @return
     */
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }

        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head.next;
        while (cur != null && cur != tail) {
            sb.append("key: " + cur.key + ", val: " + cur.val + "<->");
            cur = cur.next;
        }
        return sb.toString();
    }
}
