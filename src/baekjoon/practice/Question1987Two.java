package baekjoon.practice;

import java.util.Scanner;

public class Question1987Two {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static char[][] board;
    public static boolean[] visited = new boolean[26];
    public static int R;
    public static int C;
    public static int depth = 1;
    public static int ans = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        board = new char[R][C];

        for(int i=0;i<R;i++){
            String tmp = sc.next();
            for(int j=0;j<C;j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        solution(0, 0);

        System.out.println(ans);
    }

    public static void solution(int row, int col){
        int nx, ny;

        visited[board[row][col] - 'A'] = true;


        for(int i=0;i<4;i++){
            nx = row + dx[i];
            ny = col + dy[i];

            if(nx>=0 && nx<R && ny>=0 && ny<C) {
                if(!visited[board[nx][ny] -'A']) {
                    depth++;
                    ans = Math.max(depth, ans);
                    solution(nx, ny);

                }
            }
        }
        visited[board[row][col] - 'A'] = false;
        depth--;
    }
}
