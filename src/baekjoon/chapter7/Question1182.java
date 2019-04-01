package baekjoon.chapter7;

import java.util.Scanner;

public class Question1182 {

    static int N;
    static int S;
    static int[] arr;
    static int ans = 0;
    static int cnt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        backtracking(0, S, 0);

        System.out.println(ans);
    }

    public static void backtracking(int sum, int goal, int idx){
        if(idx>=arr.length) {
            if (sum == goal && cnt >= 1) {
                ans++;
                return;
            }
        }

        if(idx == N) return;

        backtracking(sum, goal, idx+1);

        cnt++;
        backtracking(sum+arr[idx], goal, idx+1);
        cnt--;
    }
}
