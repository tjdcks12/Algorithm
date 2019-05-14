package boj;

import java.util.Scanner;

public class samsung14890_Web {
    static int N;
    static int L;
    static int[][] map;
    static int ans;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();

        map = new int[2 * N][N];
        ans = 0;
        int count;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = N; i < 2 * N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = map[j][i - N];
            }
        }

        int i, j;

        for (i = 0; i < 2 * N; i++) {
            count = 1;
            for (j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) count++;
                else if (map[i][j] + 1 == map[i][j + 1] && count >= L) count = 1;
                else if (map[i][j] - 1 == map[i][j + 1] && count >= 0) count = 1 - L;
                else break;
            }
            if (j == (N - 1) && count >= 0) ans++;
        }


        System.out.println(ans);
    }
}
