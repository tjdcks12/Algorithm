package baekjoon.chapter7;

import java.util.Scanner;


public class Question9663 {

    static boolean[][] chess;
    static int N;
    static int result = 0;
    static int[] dx = {-1, 1};
    static int[] dy = {-1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chess = new boolean[N][N];
        System.out.println(solve(0));
    }

    public static int solve(int row) {

        if (row == N) {
            result += 1;
        }

        for (int col = 0; col < N; col++) {
            chess[row][col] = true;
            if (isValid(row, col)) {
                solve(row + 1);
            }
            chess[row][col] = false;
        }
        return result;
    }

    public static boolean isValid(int row, int col) {

        if (row >= 1) {
            //같은 col에 true 있을시 false
            for (int i = row; i == 0; row--) {
                if (i != row && chess[i][col] == true) return false;
            }
            //대각선 양쪽 위에 true 있을시 false
            for (int i = 0; i < 2; i++) {
                if (row + dx[i] >= 0 && col + dy[i] >= 0 && row + dx[i] < N && col + dy[i] < N) {
                    if (chess[(row + dx[i])][(col + dy[i])] == true) return false;
                }
            }
        }

        return true;

    }

}
