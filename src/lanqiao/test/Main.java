package lanqiao.test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();//去重
        set.add(3);
        set.add(1);
        set.add(10);

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
    public static boolean flag(int result ,int a ,int b){
        if(result%a!=0||result%b!=0) {
            return false;
        }
        return true;
    }
}
