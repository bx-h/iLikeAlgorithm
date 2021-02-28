package LRU_LFU;

import org.junit.Test;

import java.util.HashMap;

public class LRU {
    /**
     * key -> node
     */
    private HashMap<Integer, Node> map;
    /**
     * Node(k, v) <-> Node(k, v)
     */
    private DoubleList cache;
    /**
     * 最大容量
     */
    private int cap;

    public LRU(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 队尾是最近使用，队头是最远使用
     * @param key
     */
    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    /**
     * 队列头部是最远使用的，删除
     */
    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        // 已存在，不用添加，修改即可，拉到最近使用
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        // 已满，删除最远使用
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        // 加入
        addRecently(key, val);
    }

    public void showCache() {
        System.out.println(cache);
    }


    public static void main(String[] args) {
        LRU cache = new LRU(5);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.get(1);
        cache.showCache();

    }
}
