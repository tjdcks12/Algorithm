package baekjoon.chapter9;

import java.util.Scanner;


public class Question11727 {
    static int N;
    static int[] dp = new int[1001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

//        dp[0] = 1;
//        dp[1] = 1;
//        //bottom - up
//        for(int i=2;i<=N;i++){
//            dp[i] = dp[i-1] + dp[i-2] * 2;
//            dp[i] %= 10007;
//        }

//        System.out.println(dp[N]);

        System.out.println(topDown(N));
    }

    public static int topDown(int n){
        if(n == 1 || n == 0) return 1;

        if(dp[n] > 0) return dp[n];

        dp[n] = topDown(n-1) + topDown(n-2) * 2;
        dp[n] %= 10007;

        return dp[n];
    }

}
