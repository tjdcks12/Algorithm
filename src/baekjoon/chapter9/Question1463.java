package baekjoon.chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class Question1463 {
    static int[] dp = new int[1000001];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Arrays.fill(dp, 0);

//        System.out.println(solve(N));

        dp[1] = 0;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] +1;

            if(i%2 == 0){
                if(dp[i/2]+1 < dp[i]){
                    dp[i] = dp[i/2] + 1;
                }
            }

            if(i%3 == 0){
                if(dp[i/3]+1 < dp[i]){
                    dp[i] = dp[i/3] + 1;
                }
            }
        }

        System.out.println(dp[N]);

    }



    //top - down
//    public static int solve(int n) {
//        if (n == 1) {
//            return 0;
//        }
//
//        if(dp[n] > 0) return dp[n];
//        dp[n] = solve(n-1) + 1;
//
//        if(n%2 == 0) {
//            int temp = solve(n/2) + 1;
//            if(dp[n] > temp) dp[n] = temp;
//        }
//        if(n%3 == 0) {
//            int temp = solve(n/3) + 1;
//            if(dp[n] > temp) dp[n] = temp;
//        }
//
//        return dp[n];
//    }

}
