//package boj;
//
//import java.util.Scanner;
//
//public class samsung14890_2 {
//
//    static int N;
//    static int L;
//    static int[][] map;
//    static int ans;
//
//
//    public static void main(String[] args){
//
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        L = sc.nextInt();
//
//        map = new int[2*N][N];
//        ans = 0;
//
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                map[i][j] = sc.nextInt();
//            }
//        }
//
//        for(int i=N;i<2*N;i++){
//            for(int j=0;j<N;j++){
//                map[i][j] = map[j][i-N];
//            }
//        }
//
//        for(int i=0;i<N*2;i++){
//            if(check(i)) ans++;
//        }
//
//        System.out.println(ans);
//    }
//
//    public static boolean check(int idx) {
//        int valid = 1;
//
//        for(int i=0;i<N-1;i++){
//            if(map[idx][i] > map[idx][i+1]) {        // 이전 값이 더 클때 (내리막일때)
//                if (valid >= 0) valid = 1 - L;              // 유효거리가 0이상이면 유효거리를 1-L로 초기화
//                else return false;                          // 유효거리가 0보다 작으면 길이 될 수 없음
//            } else if(map[idx][i] == map[idx][i+1]){ // 이전 값과 같을때 (평지일때
//                valid++;
//            } else if(map[idx][i] < map[idx][i+1]){                                 // 이전값이 더 작을때 (오르막일때)
//                if(valid < L) return false;                 // 유효거리가 L보다 작으면 길이 될 수 없음
//                else valid = 1;                             // 유효거리가 L이상이면 유효거리를 1로 초기화
//            }
//        }
//
//        if(valid >= 0) return true; //최종 유효거리가 0이상이어야 길이 될 수 있음
//        else return false;
//    }
//}
