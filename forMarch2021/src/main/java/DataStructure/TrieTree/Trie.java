package DataStructure.TrieTree;

import org.junit.Test;

public class Trie {
    /**
     * 一颗前缀树由它的根唯一标识
     * 根不存储数据
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 时间复杂度:O(m), m为键长
     * 空间复杂度：O(m)，最坏情况下，新插入的word和已存在的trie tree没有任何公共前缀
     * @param word
     */
    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char c : chs) {
            if (!cur.containsKey(c)) {
                cur.put(c, new TrieNode());
            }
            cur = cur.get(c);
        }
        cur.setEnd();
    }

    /**
     * 时间复杂度：O(m)
     * 空间复杂度：O(1)
     * @param word
     * @return
     */
    public boolean exists(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char c : chs) {
            if (!cur.containsKey(c)) {
                return false;
            }
            cur = cur.get(c);
        }
        return cur.isEnd();
    }

    /**
     * 是否存在某前缀
     * @param prefix
     * @return
     */
    public boolean hasPrefix(String prefix) {
        char[] chs = prefix.toCharArray();
        TrieNode cur = root;
        for (char c : chs) {
            if (!cur.containsKey(c)) {
                return false;
            }
            cur = cur.get(c);
        }
        return true;
    }

    @Test
    public void test1() {
        Trie tree = new Trie();
        tree.insert("abc");
        tree.insert("abd");
        tree.insert("ade");
        System.out.println(tree.exists("abc"));
        System.out.println(tree.exists("acd"));
        System.out.println(tree.hasPrefix("ab"));
        System.out.println(tree.hasPrefix("ac"));
    }
}
