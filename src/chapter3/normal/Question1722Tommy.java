package chapter3.normal;

import java.util.Scanner;

public class Question1722Tommy {
    public static int order = 0;
    public static int N = 0;
    public static boolean[] visited;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        visited = new boolean[N+1];
        int caseNumber = sc.nextInt();
        if (caseNumber == 1 ) {
            order = sc.nextInt();
            for (int i = 1 ; i <= N; i ++) {
                solve(i, N, sb);
                if (order == 0) {
                    break;
                }
                visited = new boolean[N+1];
            }
            sb.reverse();
            System.out.println(sb.toString());
        } else {

        }

    }

    public static void solve(int current, int k, StringBuilder sb) {
        visited[current] = true;
        if (k == 1) {
            order--;
            if (order == 0) {
                sb.append(current);
                sb.append(" ");
                return;
            }
            visited[current] = false;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i <= visited.length && !visited[i]) {
                solve(i, k-1, sb);
                visited[i] =false;
                if (order == 0) {
                    sb.append(current);
                    sb.append(" ");
                    return;
                }
            }
        }

    }
}