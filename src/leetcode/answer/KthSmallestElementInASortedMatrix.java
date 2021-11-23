package leetcode.answer;

import java.util.PriorityQueue;

/**
 * leetcode 378 有序矩阵中第K个小的元素
 */
public class KthSmallestElementInASortedMatrix {

    /**
     * 解法1 优先级队列（堆）+标记数组
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int[][] tags = new int[matrix.length][matrix[0].length];
        Node node = new Node(matrix[0][0],0,0);
        tags[0][0] = 1;
        priorityQueue.add(node);
        while (!priorityQueue.isEmpty()) {
            Node n = priorityQueue.poll();
            if (n.i+1<matrix.length && tags[n.i+1][n.j] != 1) {
                priorityQueue.add(new Node(matrix[n.i+1][n.j],n.i+1,n.j));
                tags[n.i+1][n.j] = 1;
            }
            if (n.j+1<matrix[0].length && tags[n.i][n.j+1] != 1) {
                priorityQueue.add(new Node(matrix[n.i][n.j+1],n.i,n.j+1));
                tags[n.i][n.j+1] = 1;
            }
            k--;
            if (k == 0) {
                return n.val;
            }
        }
        return -1;
    }

    private static class Node implements Comparable<Node>{
        int val;
        int i;
        int j;

        public Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val,o.val);
        }
    }


    /**
     * 方法二：使用二分法方式
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left<right) {
            int mid = (left+right) >> 1;
            int count = getKthSmallestCount(matrix, mid);
            if (count < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public int getKthSmallestCount(int[][] matrix,int mid) {
        int n = matrix.length;
        int i = n-1;
        int j = 0;
        int count = 0;
        while (i >=0 && j < n) {
            if (matrix[i][j] <= mid) {
                count+=i+1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

}
