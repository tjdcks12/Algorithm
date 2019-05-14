package baekjoon.chapter10;

import java.util.Scanner;

public class Question11057 {

    static int N;
    static long[][] dp;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {

            for (int j = 0; j <= 9; j++) {
                for(int k=0;k<=j;k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }

            }
        }


        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }

        sum %= 10007;

        System.out.println(sum);
    }


}
