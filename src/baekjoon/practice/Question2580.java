package baekjoon.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2580 {

    static int[][] sdoku;
    static List<int[]> zeroIdxList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sdoku[i][j] = sc.nextInt();
                if(sdoku[i][j] == 0){
                    int tmp[] = {i, j};
                    zeroIdxList.add(tmp);
                }
            }
        }

        for(int i=1;i<=9;i++){
        }

        for(int[] tmp : zeroIdxList){
            int row = tmp[0];
            int col = tmp[1];
        }
    }


    public static boolean check(int row, int col, int num){

        int divRow = row/3;
        int divCol = col/3;

        for(int i=0;i<9;i++){
            if(sdoku[row][i] == num) return false;
            if(sdoku[i][col] == num) return false;
        }

        for(int i=divRow;i<divRow+3;i++){
            for(int j=divCol;j<divCol+3;j++){
                if(sdoku[i][j] == num) return false;
            }
        }

        return true;
    }
}
