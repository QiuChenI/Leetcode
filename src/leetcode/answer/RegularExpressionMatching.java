package leetcode.answer;

/**
 * leetcode 10题  高级算法  正则表达式匹配
 * 动态规划算法 类似通配符
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        //预处理
        boolean[] stars = new boolean[n+1];
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                stars[index-1] = true;
            } else {
                stringBuilder.append(p.charAt(i));
                index++;
            }
        }
//        System.out.println(Arrays.toString(stars));
//        System.out.println();
        p = stringBuilder.toString();
        int m = s.length();
        n = p.length();
        boolean[][] record = new boolean[n+1][m + 1];
        record[0][0] = true;
        for (int i = 1; i < n+1; i++) {
            char ch = p.charAt(i-1);
            if (stars[i-1]) {
                boolean flag =false;
                int t = 0;
                for (int j = 0; j < m+1; j++) {
                    if (record[i - 1][j]) {
                        flag = true;
                        t = j;
                    }
                    if (flag && ch != '.' && j != t &&ch != s.charAt(j-1)) {
                        flag =false;
                    }
                    if (flag) {
                        record[i][j] = true;
                    }
                }
            } else {
                for (int j = 1; j < m+1; j++) {
                    if (record[i - 1][j - 1] && (ch == s.charAt(j-1) || ch == '.')) {
                        record[i][j] = true;
                    }
                }
            }
        }
//        for (boolean[] booleans : record) {
//            System.out.println(Arrays.toString(booleans));
//        }
        return record[n][m];
    }
}
