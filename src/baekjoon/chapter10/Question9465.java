package baekjoon.chapter10;

import java.util.Scanner;

public class Question9465 {

    static int T;
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int test = 0;test<T;test++){
            N = sc.nextInt();
            map = new int[2][N];
            dp = new int[2][N];

            for(int i=0;i<N*2;i++){
                map[i/N][i%N] = sc.nextInt();
            }

            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];

            dp[0][1] = dp[1][0] + map[0][1];
            dp[1][1] = dp[0][0] + map[1][1];

            for(int i=2;i<N;i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }




    }
}
