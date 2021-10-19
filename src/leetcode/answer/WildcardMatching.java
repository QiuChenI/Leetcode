package leetcode.answer;

/**
 * LeetCode
 * 高级算法通配符匹配
 * 动态规划方法实现
 *
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = p.length()+1;
        int m = s.length()+1;
        boolean[][] signs = new boolean[n][m];
        signs[0][0] = true;
        for (int i = 1; i < n; i++) {
            char pc = p.charAt(i-1);
            if (pc == '*') {
                boolean flag = false;
                for (int j = 0;j<m;j++) {
                    if (signs[i-1][j]) {
                        flag = true;
                    }
                    if (flag) {
                        signs[i][j] = true;
                    }
                }
            } else if (pc == '?') {
                for (int j = 1;j<m;j++) {
                    if (signs[i - 1][j - 1]) {
                        signs[i][j] = true;
                    }
                }
            } else {
                for (int j = 1;j<m;j++) {
                    char sc = s.charAt(j-1);
                    if (signs[i - 1][j - 1] && sc == pc) {
                        signs[i][j] = true;
                    }
                }
            }
        }
//        for (boolean[] sign : signs) {
//            System.out.println(Arrays.toString(sign));
//        }
        return signs[n-1][m-1];
    }
}
