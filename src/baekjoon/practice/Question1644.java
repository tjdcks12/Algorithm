package baekjoon.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question1644 {
    public static boolean[] prime = new boolean[4000001];
    static ArrayList<Integer> primeList = new ArrayList<>();

    static int left = 0;
    static int right = 0;
    static int sum = 0;
    static int ans = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        getPrime(prime);

        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) primeList.add(i);
        }

        int primeSize = primeList.size();

        while (true) {
            if (sum >= N) sum -= primeList.get(left++);
            else if (right == primeSize) break;
            else sum+=primeList.get(right++);

            if(sum == N) ans++;
        }


        System.out.println(ans);

    }

    public static void getPrime(boolean[] prime) {

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }
    }
}
