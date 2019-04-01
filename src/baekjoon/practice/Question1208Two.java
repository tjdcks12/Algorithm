package baekjoon.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question1208Two {

    static int N;
    static int S;
    static int[] arr;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];

        for(int i=0;i<N;i++) {
            arr[i] = sc.nextInt();
        }

        makeSum(0, 0, N/2, arr, leftList); // 왼쪽 배열의 합을 모은 리스트
        makeSum(0, N/2, N, arr, rightList); // 오른쪽 배열의 합을 모은 리스트

        Collections.sort(leftList);
        Collections.sort(rightList);

        int leftIdx = 0;
        int rightIdx = rightList.size() - 1;

        while(leftIdx < leftList.size() && rightIdx >= 0) {

            int lv = leftList.get(leftIdx);
            int rv = rightList.get(rightIdx);

            if(lv+rv == S) {
                int lc = 0;
                while(leftIdx<leftList.size() && leftList.get(leftIdx) == lv) {
                    lc++;
                    leftIdx++;
                }

                int rc = 0;
                while(rightIdx>=0 && rightList.get(rightIdx) == rv) {
                    rc++;
                    rightIdx--;
                }

                ans+=lc*rc;
            }

            if(lv+rv > S) rightIdx--;
            if(lv+rv < S) leftIdx++;

        }

        if(S == 0) ans--; // 합계가 0인걸 찾는경우 맨 초기값이 0이므로 이 경우를 한번 빼주어야 함

        System.out.println(ans);
    }

    public static void makeSum(int sum, int idx, int endIdx, int[] arr, ArrayList<Integer> list) {
        if(idx >= endIdx) {
            list.add(sum);
            return;
        }

        makeSum(sum, idx+1, endIdx, arr, list);
        makeSum(sum+arr[idx], idx+1, endIdx, arr, list);
    }


}
