package baekjoon.chapter7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Question1987 {

    static int R;
    static int C;
    static Set<Character> characterSet = new HashSet<>();
    static char[][] board;
    static int result = 0;
    static int maxResult = 0;
    static boolean valid;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String tmp = br.readLine();

        R = Integer.parseInt(tmp.split(" ")[0]);
        C = Integer.parseInt(tmp.split(" ")[1]);


        board = new char[R][C];

        for(int i=0;i<R;i++){
            tmp = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = tmp.charAt(j);
            }
        }
        backtracking(0,0);
    }

    public static void backtracking(int row, int col){

        if(isValid(row, col)){
            result++;
            System.out.println(board[row][col]);
            if(row-1 >= 0) backtracking(row-1, col);
            if(row+1 < R) backtracking(row+1, col);
            if(col-1 >= 0) backtracking(row, col-1);
            if(col+1 < C) backtracking(row, col+1);
        }

        valid = false;
        characterSet.clear();
        result = 0;
    }

    public static boolean isValid(int row, int col){
        if(characterSet.contains(board[row][col])) return false;

        return true;
    }
}
