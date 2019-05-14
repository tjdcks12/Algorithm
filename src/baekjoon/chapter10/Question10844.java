package baekjoon.chapter10;

import java.util.Scanner;

public class Question10844 {

    static int N;
    static long dp[][];
    static long sum = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new long[N+1][10];

        for(int i=1;i<=9;i++) {
            dp[1][i] = 1;
        }

        for(int i=2;i<=N;i++) {
            for(int j=0;j<=9;j++){
                if(j > 0) dp[i][j] += dp[i-1][j-1];
                if(j < 9) dp[i][j] += dp[i-1][j+1];

                dp[i][j] %= 1000000000;
            }
        }


        for(int i=0;i<=9;i++){
            sum+=dp[N][i];
        }

        sum %= 1000000000;

        System.out.println(sum);


    }
}
