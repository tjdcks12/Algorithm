package baekjoon.chapter7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question1987solo {

    static int r;
    static int c;
    static boolean[] visited = new boolean[26];
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 1;
    static int cnt = 1;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String tmp = br.readLine();

        r = Integer.parseInt(tmp.split(" ")[0]);
        c = Integer.parseInt(tmp.split(" ")[1]);

        board = new char[r][c];

        for(int i=0;i<r;i++){
            tmp = br.readLine();
            for(int j=0;j<c;j++){
                board[i][j] = tmp.charAt(j);
            }
        }

        backtracking(0, 0); //idx는 알파벳 ascii값을 의미.
        System.out.println(ans);
    }

    public static void backtracking(int x, int y){
        visited[(int) board[x][y]-'A'] = true;

        for(int i=0;i<4;i++){
            if(x+dx[i] < r && y+dy[i] < c && x+dx[i] >= 0 && y+dy[i] >= 0) {
                int idx = board[x+dx[i]][y+dy[i]] - 'A';
                if(!visited[idx]) {
                    ans = Math.max(++cnt, ans);
                    backtracking(x + dx[i], y + dy[i]);
                }
            }
        }

        cnt--;
        visited[(int) board[x][y]-'A'] = false;


    }
}
