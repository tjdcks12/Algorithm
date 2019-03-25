package baekjoon.bfs;

import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question10026 {

    static char[][] map;
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp[j];
            }
        }

        int result = BFS();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        visited = new boolean[N][N];
        int result2 = BFS();

        System.out.println(result);
        System.out.println(result2);

    }

    public static int BFS() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j]) continue;

                visited[i][j] = true;
                queue.add(new Pair(i, j));

                while (!queue.isEmpty()) {

                    Pair cur = queue.poll();

                    for (int z = 0; z < 4; z++) {
                        int nx = (int)cur.getKey() + dx[z];
                        int ny = (int)cur.getValue() + dy[z];
                        if (!isRange(nx, ny) || visited[nx][ny] || map[i][j] != map[nx][ny]) continue;

                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));

                    }

                }
                count++;
            }
        }

        return count;

    }

    public static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;

        return true;
    }
}
