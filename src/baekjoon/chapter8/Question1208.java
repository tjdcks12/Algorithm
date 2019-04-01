package baekjoon.chapter8;

import java.util.Scanner;

public class Question1208 {
    static int arr[];
    static int N;
    static int S;
    static int ans = 0;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(0, 0);
        System.out.println(ans);
    }

    public static void solution(int sum, int idx) {
        if (idx >= arr.length) {
            if (sum == S && cnt >= 1) {
                ans++;
            }
        }
        if (idx == N) {
            return;
        }

        cnt++;
        solution(sum + arr[idx], idx + 1);
        cnt--;

        solution(sum, idx + 1);
    }
}
