//package baekjoon.practice;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Question1987 {
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int R;
//    static int C;
//    static char[][] arr;
//    static int ans = 1;
//    static int cnt = 1;
//    static boolean[] visited;
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String tmp = br.readLine();
//        R = Integer.parseInt(tmp.split(" ")[0]);
//        C = Integer.parseInt(tmp.split(" ")[1]);
//        arr = new char[R][C];
//        visited = new boolean[26];
//
//        for(int i=0;i<R;i++){
//            tmp = br.readLine();
//            for(int j=0;j<C;j++){
//                arr[i][j] = tmp.charAt(j);
//            }
//        }
//
//        solve(0,0);
//
//        System.out.println(ans);
//    }
//
//    public static void solve(int row, int col){
//        visited[(int)arr[row][col]-'A'] = true;
//
//        for(int i=0;i<4;i++){
//            int tx = row + dx[i];
//            int ty = col + dy[i];
//
//            if(tx<0 || ty<0 || tx>=R || ty>=C) continue;
//            ans = Math.max(cnt++, ans);
//            solve(tx, ty);
//
//            if()
//        }
//        --cnt;
//        visited[(int)arr[row][col]-'A'] = false;
//    }
//}
