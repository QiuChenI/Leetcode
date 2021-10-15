package leetcode.test;


import com.sun.corba.se.spi.ior.TaggedProfileTemplate;
import com.sun.xml.internal.txw2.output.IndentingXMLFilter;
import jdk.nashorn.internal.ir.ReturnNode;
import sun.font.GlyphLayout;
import sun.security.util.Length;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.function.IntFunction;

/*
2 6 4 1 5
 1 5
 */
public class Main {
    //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(solution.findWords(board, words));
//        System.out.println(solution.searchWords("eat", 0, board, 1, 3));
    }
}




class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Map<Character,List<String>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            if (map.containsKey(c)) {
                map.get(c).add(words[i]);
            } else {
                List<String> ws = new ArrayList<>();
                ws.add(words[i]);
                map.put(c,ws);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<String> list = map.get(board[i][j]);
                if (list == null) {
                    continue;
                }
                for (String s : list) {
                    if (searchWords(s,0,board,i,j)) {
                        result.add(s);
                    }
                }
            }
        }
        return result;
    }

    //查找指定字符串是否存在
    public boolean searchWords(String word,int index,char[][] board,int i,int j) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0
                || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = 1;
        boolean flag = searchWords(word, index + 1, board, i + 1, j);
        flag = flag || searchWords(word, index + 1, board, i - 1, j );
        flag = flag || searchWords(word, index + 1, board, i , j + 1);
        flag = flag || searchWords(word, index + 1, board, i , j - 1);
        board[i][j] = temp;
        return flag;
    }
}







class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//
//}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}