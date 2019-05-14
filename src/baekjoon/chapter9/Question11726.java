package baekjoon.chapter9;

import java.util.Scanner;

public class Question11726 {

    static int N;
    static int dp[] = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

//        //bottom-up
//        dp[1] = 1;
//        dp[2] = 2;
//
//        for (int i = 3; i <= N; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//            dp[i] %= 10007;
//        }

        System.out.println(solve(N));

//        System.out.println(dp[N]);

    }

    public static int solve(int n) {
        if(n == 0 || n == 1) return 1;

        if (dp[n] == 0) {
            dp[n] = solve(n - 1) + solve(n - 2);
            dp[n] %= 10007;
        }
        return dp[n];
    }
}
