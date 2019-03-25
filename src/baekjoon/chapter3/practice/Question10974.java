package baekjoon.chapter3.practice;

import java.util.Scanner;

public class Question10974 {

    private static int arr[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);


        int x = sc.nextInt();
        arr = new int[x];

        // init arr
        for (int i = 0; i < x; i++) {
            arr[i] = i + 1;
        }

        while (nextPermutation(arr));
    }

    private static boolean nextPermutation(int arr[]) {
        int i = arr.length - 1;
        int j = arr.length - 1;
        int temp;
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < arr.length; x++) {
            result.append(arr[x]).append(" ");
        }

        System.out.println(result.toString());

        while (i > 0 && arr[i] <= arr[i - 1]) i--; // 이 조건동안은 계속 루프돔

        if (i <= 0) return false;

        while (arr[j] <= arr[i - 1]) j--;

        temp = arr[j];
        arr[j] = arr[i - 1];
        arr[i - 1] = temp;

        j = arr.length - 1;

        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }



        return true;

    }
}
