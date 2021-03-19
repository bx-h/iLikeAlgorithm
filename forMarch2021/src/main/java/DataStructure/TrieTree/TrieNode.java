package DataStructure.TrieTree;

public class TrieNode {
    /**
     * 26叉树
     */
    private TrieNode[] children;
    /**
     * 26个字母
     */
    private final int R = 26;
    /**
     * 使用isEnd标识某个字符串在该树上是否存在。
     */
    private boolean isEnd;

    public TrieNode() {
        // TrieNode空数组，还未放实例。
        children = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return children[ch-'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch-'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch-'a'] = node;
    }

    public void setEnd() {
        isEnd = true;

    }

    public boolean isEnd() {
        return isEnd;
    }




}
