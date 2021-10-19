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
        String[] words = {"oath","pea","eat","rain11"};
        System.out.println(solution.isMatch("aa", "?a"));
    }
}




class Solution {

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