package baekjoon.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Question1644 {
    static boolean[] prime = new boolean[4000001];
    static int[] arr;
    static int cnt = 0;

    static int left = 0;
    static int right = 0;
    static int sum = 0;
    static int ans = 0;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) cnt++;
        }

        arr = new int[cnt];
        int idx = 0;
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) arr[idx++] = i;
        }

        while (true) {
            if (N <= sum) sum -= arr[left++];
            else if (right == arr.length) break;
            else sum += arr[right++];
            if(N == sum) ans++;
        }

        System.out.println(ans);
    }


}
