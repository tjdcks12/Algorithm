package baekjoon.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question2143 {
    static long T;

    static int n;
    static int m;

    static int[] A;
    static int[] B;

    static ArrayList<Long> AList = new ArrayList<>();
    static ArrayList<Long> BList = new ArrayList<>();

    static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        T = sc.nextLong();
        n = sc.nextInt();

        A = new int[n];

        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }

        m = sc.nextInt();
        B = new int[m];

        for(int i=0;i<m;i++) {
            B[i] = sc.nextInt();
        }


        for(int i=0;i<n;i++) {
            getSum(0, i, A, AList);
        }

        for(int i=0;i<m;i++) {
            getSum(0, i, B, BList);
        }

        for(long i : AList){
            System.out.println(i);
        }
        Collections.sort(AList);
        Collections.sort(BList);


        int leftIdx = 0;
        int rightIdx = BList.size() - 1;

        while(leftIdx < AList.size() && rightIdx >=0) {
            long lv = AList.get(leftIdx);
            long rv = BList.get(rightIdx);

            if(lv+rv == T){
                int lc = 0;
                int rc = 0;

                while(leftIdx < AList.size() && AList.get(leftIdx) == lv) {
                    leftIdx++;
                    lc++;
                }

                while(rightIdx >= 0 && BList.get(rightIdx) == rv) {
                    rightIdx--;
                    rc++;
                }

                ans+=lc*rc;
            }

            if(lv+rv > T) rightIdx--;
            if(lv+rv < T) leftIdx++;
        }


//        System.out.println(ans);


    }



    public static void getSum(long sum, int idx,  int[] arr, List list) {
        if(sum != 0) list.add(sum);

        if(idx == arr.length) return;

        getSum(sum+arr[idx], idx+1, arr, list);
    }
}
