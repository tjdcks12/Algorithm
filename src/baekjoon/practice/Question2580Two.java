package baekjoon.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2580Two {
    static int[][] sdoku;
    static List<int[]> zeroIdxList;
    static boolean isEnd = false;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sdoku = new int[9][9];
        zeroIdxList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = sc.nextInt();
                if (sdoku[i][j] == 0) zeroIdxList.add(new int[]{i, j});
            }
        }

        solve(0);


    }

    public static void solve(int idx) {
        if(isEnd) return;

        if (idx >= zeroIdxList.size()) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(sdoku[i][j]);
                    if(j!=8) sb.append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());

            isEnd = true;
            return;
        }

        int row = zeroIdxList.get(idx)[0];
        int col = zeroIdxList.get(idx)[1];

        for (int i = 1; i <= 9; i++) {
            if (!check(row, col, i)) continue;
            sdoku[row][col] = i;
            solve(idx + 1);
            sdoku[row][col] = 0;
        }
    }

    public static boolean check(int row, int col, int nowValue) {

        //같은 행 검사
        for (int i = 0; i < 9; i++) {
            if (sdoku[row][i] == nowValue) return false;
        }

        //같은 열 검사
        for (int i = 0; i < 9; i++) {
            if (sdoku[i][col] == nowValue) return false;
        }

        //같은 구역 검사
        int divRow = (row / 3) * 3;
        int divCol = (col / 3) * 3;
        for (int i = divRow; i < divRow + 3; i++) {
            for (int j = divCol; j < divCol + 3; j++) {
                if (sdoku[i][j] == nowValue) return false;
            }
        }
        return true;
    }
}
