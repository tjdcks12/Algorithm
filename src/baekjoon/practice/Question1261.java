package baekjoon.practice;

import java.util.*;

public class Question1261 {
    public static Deque<int[]> deque = new ArrayDeque<>();
    public static int N;
    public static int M;
    public static int[][] miro;
    public static int[][] count;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        miro = new int[M][N];
        count = new int[M][N];

        for(int i=0;i<M;i++){
            String tmp = sc.next();

            for(int j=0;j<N;j++){
                miro[i][j] = tmp.charAt(j) -'0';
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                count[i][j] = -1;
            }
        }

        count[0][0] = 0;
        deque.addFirst(new int[]{0,0});

        while(!deque.isEmpty()){
            int[] tmp = deque.poll();
            int x, y, nx, ny;

            x = tmp[0];
            y = tmp[1];

            for(int i=0;i<4;i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    if(count[nx][ny] != -1){ //만약 방문해본적 있으면
                    } else{ //방문한적이 없으면
                        count[nx][ny] = 0;
                        if(miro[nx][ny] == 1){ //벽에 막혀있으면

                            count[nx][ny] = count[x][y] + 1;
                            deque.addLast(new int[]{nx, ny});
                        } else{ // 막혀있지 않으면

                            count[nx][ny] = count[x][y];
                            deque.addFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        System.out.println(count[M-1][N-1]);

    }


}
