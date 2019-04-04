package baekjoon.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Question7453 {

    static int N;
    static int[][] arr;
    static int[] AB;
    static int[] CD;
    static int ans = 0;

    //기본 전략 : 2개로나눠서 각 배열의 합을 완전탐색으로 리스트에 추가하고 리스트 하나 순회하면서 다른 리스트의 각 값과 비교해서 합이 0일때마다 추가.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


        arr = new int[4][N];

        AB = new int[N*N];
        CD = new int[N*N];

        for (int i = 0; i < N; i++) {
            arr[0][i] = sc.nextInt();
            arr[1][i] = sc.nextInt();
            arr[2][i] = sc.nextInt();
            arr[3][i] = sc.nextInt();
        }

        int idx=0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = arr[0][i] + arr[1][j];
                CD[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int min = 0;
        int max = N*N - 1;

        while(min < N*N && max >=0) {
            int lv = AB[min];
            int rv = CD[max];

            if(lv+rv == 0){
                int lc = 0;
                int rc = 0;
                while(min < N*N && AB[min] == lv) {
                    lc++;
                    min++;
                }
                while(max >= 0 && CD[max] == rv){
                    rc++;
                    max--;
                }
                ans+=lc*rc;
            }
            if(lv+rv > 0) max--;
            if(lv+rv < 0) min++;
        }

        System.out.println(ans);


    }
}
