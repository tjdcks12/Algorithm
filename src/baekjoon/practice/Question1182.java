package baekjoon.practice;

import java.util.Scanner;

public class Question1182 {

    public static int N;
    public static int S;
    public static int[] arr;
    public static int ans = 0;
    public static int calc = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        solution(0, 0);
        System.out.println(ans);

    }

    public static void solution(int sum, int idx) {
        if(idx>=arr.length) {
            if (sum == S && calc >= 1) {
                ans++;
                return;
            }
        }

        if(idx == N) return;

        solution(sum, idx+1);

        calc++;
        solution(sum+arr[idx], idx+1);
        calc--;
    }

}
