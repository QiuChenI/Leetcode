package leetcode.test;


import com.sun.corba.se.spi.ior.TaggedProfileTemplate;
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
        System.out.println(solution.partition("cbbbcc"));
    }
}




class Solution {
    boolean[][] flag;
    List<String> ans = new LinkedList<>();
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        int n = s.length();
        flag = new boolean[n][n];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i],true);
        }
        for (int i = n-1;i>=0;i--) {
            for (int j = i+1;j<n;j++) {
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i+1][j-1];
            }
        }
        getAllPlalindrome(res,0,s);
        return res;
    }


    /**
     *
     * @param res 结果集合
     */
    public void getAllPlalindrome(List<List<String>> res,int i,String s) {
        //走到最后要停止
        if (i >= s.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i;j < s.length();j++) {
            if (flag[i][j]) {
                String sub = s.substring(i,j+1);
                ans.add(sub);
                getAllPlalindrome(res,j+1,s);
                ans.remove(ans.size()-1);
            }
        }
    }
}




class Heap<T extends Comparable<T>> {

    //数据存储堆结构
    private Object[] heap;
    //是否是大根堆
    private boolean isBigRoot;
    //默认堆初始空间大小
    private static final int DEFAULTLENT = 16;
    //设置堆空间大小
    private int lent;

    @Override
    public String toString() {
        return "Heap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }

    //元素个数
    private int size = 0;

    public Heap(boolean isBigRoot) {
        this.isBigRoot = isBigRoot;
        init();
    }

    public Heap(boolean isBigRoot, int lent) {
        this.isBigRoot = isBigRoot;
        this.lent = lent;
        init();
    }

    //堆初始化
    private void init() {
        if (lent <= 0) {
            heap = new Object[DEFAULTLENT];
        } else {
            heap = new Object[lent];
        }
    }

    public void inset(T arg) {
        if (size >= heap.length) {//进行扩容
            Object[] temp = new Object[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                temp[i] = heap[i];
            }
            heap = temp;
        }
        heap[size++] = arg;
        if (size > 1) {
            siftUp();
        }

//        System.out.println(Arrays.toString(heap));
    }

    /**
     * 末尾添加元素 向上调整
     * (i-1)/2   (i-2)/2
     */
    private void siftUp() {
        int index = size - 1;
        int subTreeRoot;
        while (index > 0) {
            T temp1 = (T) heap[(index - 1) / 2];
            T tempI = (T) heap[index];
            if (isBigRoot) {
                if (tempI.compareTo(temp1) > 0) {
                    swap(index, (index - 1) / 2);
                    index = (index - 1) / 2;
                } else {
                    return;
                }
            } else {
                if (tempI.compareTo(temp1) > 0) {
                    return;
                } else {
                    swap(index, (index - 1) / 2);
                    index = (index - 1) / 2;
                }
            }
        }
    }

    public T peek() {
        return (T) heap[0];
    }


    /**
     * 得到堆顶元素,并删除堆顶元素
     *
     * @return 返回堆顶元素
     */
    public T pop() {
        T result = (T) heap[0];
        swap(0, size - 1);
        heap[size - 1] = null;
        size--;
        siftDown();
        return result;
    }

    /**
     * 头部放出元素向下调整
     * 2i + 1 左子树
     * 2i + 2 右子树
     **/
    private void siftDown() {
        int index = 0;
        while (index * 2 + 1 < size) {
            T tIndex = (T) heap[index];
            T left = (T) heap[2 * index + 1];
            T right = (T) heap[2 * index + 2];
            if (isBigRoot) {
                int maxIndex;
                T max;
                if (right == null) {
                    maxIndex = 2 * index + 1;
                    max = left;
                } else {
                    maxIndex = left.compareTo(right) > 0 ? 2 * index + 1 : 2 * index + 2;
                    max = (T) heap[maxIndex];
                }
                if (max.compareTo(tIndex) > 0) {
                    swap(index, maxIndex);
                    index = maxIndex;
                } else {
                    return;
                }
            }
            if (!isBigRoot) {
                int minIndex;
                T min;
                if (right == null) {
                    minIndex = 2 * index + 1;
                    min = left;
                } else {
                    minIndex = left.compareTo(right) < 0 ? 2 * index + 1 : 2 * index + 2;
                    min = (T) heap[minIndex];
                }
                if (min.compareTo(tIndex) < 0) {
                    swap(index, minIndex);
                    index = minIndex;
                } else {
                    return;
                }
            }
        }
//        System.out.println(Arrays.toString(heap));
    }

    /**
     * 位置交换
     */
    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
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