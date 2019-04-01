package baekjoon.chapter8;

import java.util.Scanner;

public class Question2003 {

    static int N;
    static int M;
    static int[] arr;
    static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++){
            solution(0, i);
        }
        System.out.println(ans);
    }

    public static void solution(int sum, int idx) {
        if(sum == M) {
            ans++;
            return;
        }
        if(sum > M){
            return;
        }

        if(idx >= arr.length) return;

        solution(sum + arr[idx], idx+1);


    }
}
