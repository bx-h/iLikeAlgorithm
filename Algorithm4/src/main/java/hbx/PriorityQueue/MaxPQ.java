package hbx.PriorityQueue;

/**
 * 最大堆，有效范围是：[1, length]
 * 左节点为：
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    /**
     * 最大堆数组。有效范围是[1, length]
     */
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    /**
     * 最大堆的第一个元素即为最大值
     *
     * @return 最大元素
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 在尾部插入，然后上浮。
     *
     * @param e 要插入的元素
     */
    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);

    }

    /**
     * 获取第一个元素，交换第一个元素与最后一个元素，删除最后一个元素（为之前的最大元素），下沉头部元素（为之前的最后一个元素）
     *
     * @return 最大元素
     */
    public Key delMax() {
        Key max = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 上浮。如果 pq[k] > pq[父亲], 则上浮
     *
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && compare(parent(k), k) > 0) {
            exch(k, parent(k));
            k = parent(k);
        }

    }

    /**
     * 下沉。如果pq[k] < max(left[k], right[k])，下沉
     *
     * @param k
     */
    private void sink(int k) {
        // 有left不一定有right，有right肯定有left。所以先判断left。
        while (left(k) <= N) {
            int larger = left(k);
            // 如果pq[left] < pq[right], largerIndex = right
            if (right(k) <= N && compare(left(k), right(k)) < 0) {
                larger = right(k);
            }
            // 如果pq[k] > max(pq[left], pq[right]), 不用下沉了。
            if (compare(k, larger) > 0) {
                break;
            }
            // 交换
            exch(k, larger);
            k = larger;

        }
    }

    /**
     * 交换两数。
     *
     * @param i 第一个数的下标
     * @param j 第二个数的下标
     */
    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private int compare(int i, int j) {
        assert j > 0 && i > 0 && j < pq.length && i < pq.length;
        return pq[i].compareTo(pq[j]);
    }

    /**
     * 下面三个函数都是返回的下标
     * @param k
     * @return
     */
    public int parent(int k) {
        return k / 2;
    }

    public int left(int k) {
        return k * 2;
    }

    public int right(int k) {
        return k * 2 + 1;
    }
}
