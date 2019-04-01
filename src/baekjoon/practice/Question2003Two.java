package baekjoon.practice;

import java.util.Scanner;

public class Question2003Two {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int ans = 0;
    public static int sum = 0;
    public static int left = 0;
    public static int right = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        for(int i=0; i<N;i++){
            arr[i] = sc.nextInt();
        }
        sum = arr[0];

        while(left < N && right < N){
            if(sum < M){
                right++;
                if(right == N) continue;
                sum += arr[right];
            } else if(sum == M){
                ans++;
                right++;
                if(right == N) continue;
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }


        System.out.println(ans);
    }
}
