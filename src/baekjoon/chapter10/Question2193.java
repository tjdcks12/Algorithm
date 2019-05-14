package baekjoon.chapter10;

import java.util.Scanner;

public class Question2193 {

    static int N;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new long[N + 1];

        System.out.println(topDown(N));


    }

    public static long topDown(int n) {
        if (n == 1 || n == 2) return 1;

        if (dp[n] == 0) {
            return dp[n] = topDown(n - 1) + topDown(n - 2);
        } else return dp[n];
    }

}
