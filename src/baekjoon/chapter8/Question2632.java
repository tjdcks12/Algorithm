package baekjoon.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question2632 {

    static int target;
    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static ArrayList<Integer> AList = new ArrayList<>();
    static ArrayList<Integer> BList = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        target = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N];
        B = new int[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            makeSum(0, 0, N, A, AList);
        }

        for (int j = 0; j < M; j++) {
            makeSum(0, 0, M, B, BList);
        }


        Collections.sort(AList);
        Collections.sort(BList);

        for (int i : AList) {
            System.out.println(i);
        }

        System.out.println("++++++++++++++++");
        for (int i : BList) {
            System.out.println(i);
        }

        int leftIdx = 0;
        int rightIdx = BList.size() - 1;

        while (leftIdx < AList.size() && rightIdx >= 0) {
            int lv = AList.get(leftIdx);
            int rv = BList.get(rightIdx);

            if (lv + rv == target) {
                if (lv == 0 || rv == 0) break;

                System.out.println("left배열의 값 : " + lv + ", right배열의 값 : " + rv);

                int lc = 0;
                int rc = 0;

                while (leftIdx < AList.size() && AList.get(leftIdx) == lv) {
                    lc++;
                    leftIdx++;
                    System.out.println("left count는 : " + lc);
                }
                while (rightIdx >= 0 && BList.get(rightIdx) == rv) {
                    rc++;
                    rightIdx--;
                    System.out.println("right count는 : " + rc);

                }

                ans += lc * rc;
            }

            if (lv + rv < target) leftIdx++;
            if (lv + rv > target) rightIdx--;
        }

        System.out.println(ans);
    }

    public static void makeSum(int sum, int startIdx, int endIdx, int[] arr, ArrayList list) {
        if (sum == target) {
            System.out.println("한개의 피자판에서 판매");
            ans++;
        }
        list.add(sum);

        if(startIdx != endIdx) makeSum(sum + arr[startIdx], startIdx + 1, endIdx, arr, list);

    }
}
