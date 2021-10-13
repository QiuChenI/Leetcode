package leetcode.test;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestDemo {

    @Test
    public void test1() {
        List<List<String>> res = new LinkedList<>();
        List<String> strings = new LinkedList<>();
        res.add(strings);
        System.out.println(res.get(0));
    }


    @Test
    public void exercise1() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
        System.out.println(score >= 60 ? "及格" : "不及格");
    }

    @Test
    public void exercise2() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        if (score == 100) {
            System.out.println("奖励一辆BMW");
        } else if (score > 80){
            System.out.println("奖励一台iphone7plus");
        } else if (score > 60 ) {
            System.out.println("奖励一个 iPad");
        } else {
            System.out.println("什么奖励也没有");
        }
    }


    @Test
    public void exercise3() {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        if (num1 > num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        if (num1 > num3) {
            int temp = num3;
            num3 = num1;
            num1 = temp;
        }
        if (num2 > num3) {
            int temp = num3;
            num3 = num2;
            num2 = temp;
        }
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    /*
    高：180cm以上；富：财富1千万以上；帅：是。
    如果这三个条件同时满足，则：“我一定要嫁给他!!!”
    如果三个条件中有为真的情况，则：“嫁吧，比上不足，比下有余。”
    如果三个条件都不满足，则：“不嫁！”
     */
    @Test
    public void exercise4() {
        Scanner input=new Scanner(System.in);
        System.out.println("身高:(cm)");
        int height = input.nextInt();
        System.out.println("财富:(千万)");
        double money = input.nextDouble();
        System.out.println("帅:(true / false)");
        boolean isBeautiful = input.nextBoolean();
        if (height > 180 && money > 1 && isBeautiful) {
            System.out.println("我一定要嫁给他!!!");
        } else if (height > 180 || money > 1 || isBeautiful) {
            System.out.println("嫁吧，比上不足，比下有余。");
        } else {
            System.out.println("不嫁！");
        }
    }

    @Test
    public void exercise5() {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if(a==0 && b == 0) {
            System.out.println("不是方程");
        } else if (b == 0){
            System.out.println("该方程解是：" + (-c/a));
        }

        double t = Math.pow(b,2) - 4 * a * c;
        if (t > 0) {
            double temp = Math.sqrt(t);
            System.out.println("有两个实根 实根1="+((-b+temp)/2*a)+"   实根2="+((-b-temp)/2*a));
        } else if (t == 0){
            System.out.println("有一个根："+(-b/2*a));
        } else {
            System.out.println("此方程无解");
        }
    }
}
