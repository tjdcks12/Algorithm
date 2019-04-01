package baekjoon.chapter8;

import java.util.Scanner;

public class Question2003BOJ {
    static int n;
    static int m;
    static int[] a;
    static int left = 0;
    static int right = 0;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int sum = 0;

        while (true) {
            if (sum >= m) sum -= a[left++];
            else if (right == n) break;
            else sum += a[right++];
            if (sum == m) ans++;
        }

        System.out.println(ans);
    }
}
