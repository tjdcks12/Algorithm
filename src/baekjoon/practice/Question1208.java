package baekjoon.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1208 {

    public static int N;
    public static int S;

    public static int[] arr;
    public static int ans = 0;
    public static int cnt = 0;

    public static List<Integer> firstList = new ArrayList<>();
    public static List<Integer> secondList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int mid = N/2;

        recursive(firstList, 0, 0, mid);
        recursive(secondList, 0, mid, arr.length);

        for(int i=0;i<firstList.size();i++){
            for(int j=0;j<secondList.size();j++){
                if(firstList.get(i) + secondList.get(j) == S) ans++;
            }
        }

        System.out.println(ans);
    }

    public static void recursive(List list, int sum, int idx, int lastIdx){

        if(idx>=lastIdx) {
            if (sum == S && cnt >= 1) {
                ans++;
            }
        }

        if(idx == lastIdx) return;

        recursive(list, sum, idx+1, lastIdx);

        list.add(sum+arr[idx]);
        cnt++;
        recursive(list, sum+arr[idx], idx+1, lastIdx);
        cnt--;
    }
}
