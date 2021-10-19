package leetcode.answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 高级算法 回溯法
 * 删除无效括号
 */
public class DeleteInvalidParentheses {
    private Set<String> set;//多次添加删除 链表增加效率
    char[] cs ;

    public List<String> removeInvalidParentheses(String s) {
        cs = s.toCharArray();
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                leftRemove++;
            } else if (cs[i] == ')') {
                if (leftRemove==0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }
        char[] chars = new char[s.length()];
        set = new HashSet<>();
        BFS(chars,0,0,0,0,leftRemove,rightRemove);
        return new ArrayList<>(set);
    }

    //深度优先搜索括号的所有情况  利于剪枝
    public void BFS(char[] chars,int i,int j,int left,int right,int leftRemove,int rightRemove) {
        //匹配到结束
        if (j >= cs.length) {
            if (leftRemove==0 && rightRemove==0) {
                set.add(new String(chars,0,i));
            }
            return;
        }
        char ch = cs[j];
        if (ch == '(' && leftRemove > 0) {//删除
            BFS(chars,i,j+1,left,right,leftRemove-1,rightRemove);
        } else if (ch == ')' && rightRemove > 0) {
            BFS(chars,i,j+1,left,right,leftRemove,rightRemove-1);
        }
        chars[i] = ch;
        if (ch != '(' && ch != ')') {
            BFS(chars,i+1,j+1,left,right,leftRemove,rightRemove);//不删除
        }
        if (ch == '(') {
            BFS(chars,i+1,j+1,left+1,right,leftRemove,rightRemove);//不删除
        } else if (left>right){
            BFS(chars,i+1,j+1,left,right+1,leftRemove,rightRemove);//不删除
        }
    }
}
