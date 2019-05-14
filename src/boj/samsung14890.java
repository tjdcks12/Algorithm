//package boj;
//import java.util.*;
//public class samsung14890 {
//    static int n, l, ans;
//    static int[][] a = new int[101][101], b = new int[101][101];
//    static void check(int row, int a[][]) {
//        boolean c[] = new boolean[n];
//        int temp = a[row][0];
//        for (int i = 0; i < n; i++) {
//            if (a[row][i] != temp) {
//                if (Math.abs(a[row][i] - temp) > 1) return; //차이가 1보다 클경우 종료
//
//                if (a[row][i] < temp) { //다음것이 나보다 작을 경우(오른쪽 경사로)
//                    int num = -1;
//                    for (int j = i; j <= i + l - 1; j++) {
//                        if (j >= n || c[j]) return; // j가 인덱스 넘어갈경우 or 이미 체크된 경우 종료
//                        c[j] = true; // 체크 배열 변경(방문함으로)
//                        if (num == -1) {  // 맨 처음 num이 세팅되는경우 (for문 처음 진입시에만 해당됨)
//                            num = a[row][j]; /// 해당 road의 값으로 num 값 변경
//                            continue; // for문 되돌아가서 반복
//                        }
//                        if (num != -1 && a[row][j] != num) return; // 처음진입이 아닌데 num값과 다른 경우에 (
//                    }
//                    i = i + l - 1; // i값 초기화 i ~ i+l-1 까지의 검사를 완료했으니 그만큼 한번에 넘어감
//                    if (i >= n) break; // i값 초기화 한것이 배열 인덱스범위를 넘어설경우 종료
//                }
//                else { //다음것이 나보다 큰 경우(왼쪽 경사로)
//                    int num = -1;
//                    for (int j = i - 1; j >= i - l; j--) {
//                        if (j < 0 || c[j]) return;
//                        c[j] = true;
//                        if (num == -1) {
//                            num = a[row][j];
//                            continue;
//                        }
//                        if (num != -1 && a[row][j] != num) return;
//                    }
//                }
//                temp = a[row][i];
//            }
//        }
//        ++ans;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        l = in.nextInt();
//        for(int i=0; i<n; i++)
//            for(int j=0; j<n; j++){
//                a[i][j] = in.nextInt();
//                b[j][i] = a[i][j];
//            }
//
//        for(int i=0; i<n; i++){
//            check(i,a);
//            check(i,b);
//        }
//        System.out.println(ans);
//        in.close();
//    }
//}