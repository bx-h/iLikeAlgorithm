package LRU_LFU;

import java.util.*;

/**
 * 1、调用get(key)方法时，要返回该key对应的val。<br/>
 * 2、只要用get或者put方法访问一次某个key，该key的freq就要加一。<br/>
 * 3、如果在容量满了的时候进行插入，则需要将freq最小的key删除，如果最小的freq对应多个key，则删除其中最旧的那一个。<br/>
 */
public class LFU {
    /**
     * Node: [val, freq]
     */
    HashMap<Integer, int[]> keyToNode;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    int minFreq;
    int cap;

    public LFU(int capacity) {
        keyToNode = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        // 增加Node的freq，还要修改freq表。
        increaseFreq(key);
        return keyToNode.get(key)[0];

    }

    public void put(int key, int val) {
        if (this.cap <= 0) return;
        // 已存在，修改即可
        if (keyToNode.containsKey(key)) {
            int[] node = keyToNode.get(key);
            keyToNode.put(key, new int[]{val, node[1]});
            increaseFreq(key);
            return;
        }
        // 满了，要删一个
        if (this.cap <= keyToNode.size()) {
            removeMinFreqKey();
        }

        keyToNode.put(key, new int[]{val, 1});
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新值，最小频度肯定是1
        this.minFreq = 1;

    }

    private void increaseFreq(int key) {
        int[] node = keyToNode.get(key);
        int freq = node[1];
        keyToNode.put(key, new int[]{node[0], freq + 1});
        //更新freq表
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 如果该freq对应的key列表空了，删除。
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }

    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 最先插入的，是最老的
        int candidate = keyList.iterator().next();
        keyList.remove(candidate);
        // 该频率对应的key表空了
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }

        keyToNode.remove(candidate);
    }

    public void showCache() {
        keyToNode.entrySet().forEach(val->{
            System.out.printf("key: %d -> (val: %d, freq: %d)\n", val.getKey(), val.getValue()[0], val.getValue()[1]);
        });
    }

    public static void main(String[] args) {
        LFU cache = new LFU(2);
        cache.put(1, 10);
        cache.put(2, 20);
        // 查询 key 为 1 对应的 val
        // 返回 10，同时键 1 对应的 freq 变为 2
        int res = cache.get(1);
        System.out.println("get 1: " + res);
        cache.showCache();

        // 容量已满，淘汰 freq 最小的键 2
        // 插入键值对 (3, 30)，对应的 freq 为 1
        cache.put(3, 30);
        cache.showCache();

        // 键 2 已经被淘汰删除，返回 -1
        res = cache.get(2);
        System.out.println("get 2: " + res);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {return o2.compareTo(o1);});
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.offer(10);
        maxHeap.offer(21);
        maxHeap.offer(9);
        System.out.println(maxHeap.peek());








    }

}
