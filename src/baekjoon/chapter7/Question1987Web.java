package baekjoon.chapter7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question1987Web {


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r;
    static int c;
    static int cnt = 1;
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String tmp = sc.readLine();

        r = Integer.parseInt(tmp.split(" ")[0]);
        c = Integer.parseInt(tmp.split(" ")[1]);
        char[][] map = new char[r][c];

        boolean[] visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            map[i] = sc.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = (char) (map[i][j] - 'A');
            }
        }

        dfs(map, visited, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(char[][] map, boolean[] visited, int y, int x) {
        int idx = map[y][x];
        visited[idx] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= nx && nx < c && 0 <= ny && ny < r) {
                int next = map[ny][nx];

                if (!visited[next]) {
                    ans = Math.max(++cnt, ans);
                    dfs(map, visited, ny, nx);
                }
            }
        }

        // 초기화
        --cnt;
        visited[idx] = false;


    }
}
