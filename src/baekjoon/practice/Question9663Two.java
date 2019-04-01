package baekjoon.practice;

import java.util.Scanner;

public class Question9663Two {
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
        if(row == N){
            ans++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!check(row, i)) continue;
            chess[row][i] = true;
            solve(row+1);
            chess[row][i] = false;
        }
    }

    public static boolean check(int row, int col) {

        for(int i=row;i>=0;i--){ // 세로 줄 검사
            if(chess[i][col]) return false;
        }

        //왼쪽 대각선 검사
        int dx = -1;
        int dy = -1;

        int newRow = row+dx;
        int newCol = col+dy;

        while(newRow>=0 && newCol>= 0){
            if(chess[newRow--][newCol--] == true) return false;
        }

        //오른쪽 대각선 검사
        dx = -1;
        dy = 1;

        newRow = row+dx;
        newCol = col+dy;

        while(newRow>=0 && newCol< N){
            if(chess[newRow--][newCol++] == true) return false;
        }

        return true;
    }



}
