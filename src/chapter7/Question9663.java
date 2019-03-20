//package chapter7;
//
//import java.util.Scanner;
//
//
//public class Question9663 {
//    static int ans = 0;
//    static int n;
//    static int[] col;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        n = sc.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            col = new int[n + 1];
//            col[1] = i;
//            dfs(1);
//        }
//
//        System.out.println(ans);
//    }
//
//
//    public static void dfs(int row) {
//
//
//        if (row == n) ans++;
//        else {
//            for (int i = 1; i <= n; i++) {
//                col[row + 1] = i;
//                if (isPossible(row + 1)) {
//                    dfs(row + 1);
//                } else {
//                    col[row + 1] = 0;
//                }
//            }
//        }
//        col[row] = 0; // back tracking 초기화
//    }
//
//    public static boolean isPossible(int num) {
//        for (int i = 1; i < num; i++) { // num 이전 행들을 탐색하면서 그행에 queen 의 열과 일치하는 것이 있는지 탐색
//            if (col[num] == col[i]) {
//                return false;
//            }
//
//            if (Math.abs(i - num) == Math.abs(col[i] - col[num])) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
