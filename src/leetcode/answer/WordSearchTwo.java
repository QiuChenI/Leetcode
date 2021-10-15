package leetcode.answer;

import java.util.*;

/**
 * LeetCode 高级算法：单词搜索2
 * 前缀树解法
 */
public class WordSearchTwo {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        //构建前缀树
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                searchWords(trie,board,i,j,result);
            }
        }
        return new ArrayList<>(result);
    }

    //查找指定字符串是否存在
    public void searchWords(Trie trie,char[][] board,int i,int j,Set<String> set) {
        if (i < 0 || i >= board.length || j < 0
                || j >= board[0].length  || board[i][j] == '#') {
            return;
        }
        char c  = board[i][j];
        Trie node = trie.children.get(c);
        if (node == null) {
            return;
        }
        if (node.isWord) {
            set.add(node.word);
            node.isWord=false;
        }
        if (!node.children.isEmpty()) {
            board[i][j] = '#';
            for (int[] dir : dirs) {
                searchWords(node, board, i + dir[0], j + dir[1], set);
            }
            board[i][j] = c;
        } else {
            trie.children.remove(board[i][j]);
        }

    }

    class Trie {
        private String word;
        private Map<Character, Trie> children;
        private boolean isWord;

        public Trie() {
            children = new HashMap<>();
            isWord = false;
        }

        public void insert(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!node.children.containsKey(chars[i])) {
                    node.children.put(chars[i],new Trie());
                }
                node = node.children.get(chars[i]);
            }
            node.word = word;
            node.isWord = true;
        }
    }
}
