package baekjoon.practice;

import java.util.Scanner;

public class Question9663 {

    static int N;
    static boolean[][] chess;
    static int result = 0;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        chess = new boolean[N][N];

        calc(0);
        System.out.println(result);


    }

    public static void calc(int row){
        if(row == N) {
            result++;
            return;
        }

        for(int col=0;col<N;col++){
            if(!check(row, col)) continue;
            chess[row][col] = true;
            calc(row+1);
            chess[row][col] = false;
        }

    }

    public static boolean check(int row, int col){
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

        //왼쪽 대각선 검사
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
