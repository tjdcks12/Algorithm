package baekjoon.chapter9;

import java.util.Scanner;

public class Question9095 {

    static int N;
    static int[] dp = new int[11];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        System.out.println(dp[N]);
    }
}
