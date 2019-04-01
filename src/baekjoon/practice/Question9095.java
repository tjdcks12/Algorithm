package baekjoon.practice;

import java.util.Scanner;

public class Question9095 {
    static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();

        go(0, goal);

        System.out.println(result);

    }

    public static void go(int sum, int goal) {
        if(sum>goal) return;
        if(sum==goal) {
            result++;
            return;
        }

        go(sum+1, goal);
        go(sum+2, goal);
        go(sum+3, goal);
    }
}