package baekjoon.chapter7;

import java.util.Scanner;

public class Question2580solo {
    static int[][] sdoku = new int[9][9];
    static boolean[] check = new boolean[10];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sdoku[i][j] = sc.nextInt();
            }
        }

        go(0);
    }

    public static void go(int idx){

        if(idx == 81) return;


        int x = idx/9;
        int y = idx%9;

        if(sdoku[x][y] != 0){
            go(idx+1);
        } else{

        }
    }

    public static void refreshCheck(){
        for(int i=1;i<=9;i++){
            check[i] = false;
        }
    }

    public static boolean rowCheck(int row, int x){
        for(int i=0;i<9;i++){
            if(sdoku[row][i] == x) return false;
        }
        return true;
    }

    public static boolean colCheck(int col, int x){
        for(int i=0;i<9;i++){
            if(sdoku[i][col] == x) return false;
        }
        return true;
    }

    public static boolean boxCheck(int row, int col, int x){
        int rowIdx = row/3;
        int colIdx = col/3;

        for(int i=rowIdx;i<rowIdx+3;i++){
            for(int j=colIdx;j<colIdx+3;j++){
                if(sdoku[i][j] == x) return false;
            }
        }
        return true;
    }
}
