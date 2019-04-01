package practice;

import java.util.Scanner;

public class Question9095 {

    static int N;
    static int goal;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            goal = sc.nextInt();
            solve(0, goal);
            System.out.println(ans);
            ans = 0;
        }
    }

    public static void solve(int sum, int goal) {
        if (sum == goal) {
            ans++;
            return;
        }
        if (sum > goal) return;

        solve(sum + 1, goal);
        solve(sum + 2, goal);
        solve(sum + 3, goal);
    }
}
