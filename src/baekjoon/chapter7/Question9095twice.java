package baekjoon.chapter7;

import java.util.Scanner;

public class Question9095twice {
    static int N;
    static boolean[][] chess;
    static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chess = new boolean[N][N];

        solve(0);
        System.out.println(ans);

    }

    public static void solve(int row){
        if(row == N) {
            ans++;
            return;
        }

        // col을 1씩 늘려가면서 체스 놓기
        for(int i=0;i<N;i++){
            if(!isValid(row, i))continue;

            chess[row][i] = true;
            solve(row+1);
            chess[row][i] = false;
        }
    }

    public static boolean isValid(int row, int col){


        for(int i=row;i>=0;i--){
            if(chess[i][col]) return false;
        }


        //왼쪽 위 대각선
        int tr = row-1;
        int tc = col-1;

        while(tr >= 0 && tc >= 0){
            if(chess[tr--][tc--]) return false;
        }

        tr = row - 1;
        tc = col + 1;

        while(tr >= 0 && tc < N){
            if(chess[tr--][tc++]) return false;
        }
        return true;
    }
}
