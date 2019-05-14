//package practice;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Question14502 {
//
//    static int N;
//    static int M;
//    static int[][] A;
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static ArrayList<int[]> virusList = new ArrayList<>();
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        M = sc.nextInt();
//        N = sc.nextInt();
//        A = new int[N][M];
//
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                A[i][j] = sc.nextInt();
//                if(A[i][j] == 2) virusList.add(new int[]{i, j});
//            }
//        }
//
//
//        // 벽세우기
//
//        {
////            spreadVirus();
//        }
//
//
//
//
//    }
//
//
//    public static void spreadVirus(int[] virusLocation){
//        Queue<int[]> queue = new LinkedList<>();
//
//        queue.add(virusLocation);
//
//        while(!queue.isEmpty()){
//            int temp[] = queue.poll();
//            int x = temp[0];
//            int y = temp[1];
//
//            for(int i=0;i<4;i++){
//                int nx = x+dx[i];
//                int ny = y+dy[i];
//                if(nx>=0 && nx<M && ny>=0 && ny<N) {
//                    if(A[nx][ny] == 0) {
//                        A[nx][ny] = 2;
//                        queue.add(new int[] {nx, ny});
//                    }
//                }
//            }
//        }
//
//
//
//
//        for(int i=0;i<4;i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx>=0 && nx<M && ny>=0 && ny<N) {
//                if(A[nx][ny] == 0) {
//                    A[nx][ny] = 2;
//                    spreadVirus(new int[]{nx,ny});
//                }
//            }
//        }
//    }
//}
