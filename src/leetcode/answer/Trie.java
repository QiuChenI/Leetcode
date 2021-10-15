package leetcode.answer;

/**
 * 字典树-->也叫前缀树
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = chars[i] - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie();
            }
            node = node.children[j];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = startsPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return startsPrefix(prefix) != null;
    }

    public Trie startsPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.children[j] != null) {
                node = node.children[j];
            } else {
                return null;
            }
        }
        return node;
    }
}
