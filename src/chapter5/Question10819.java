package chapter5;

import java.util.Arrays;
import java.util.Scanner;

public class Question10819 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        int fact[] = new int[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        //sort
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n-i-1; j++) {
//                int temp;
//                if(arr[j]>arr[j+1]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }

        Arrays.sort(arr, 0, arr.length);

        int ans = 0;
        do{
            int temp = calc(arr);
            ans = Math.max(ans, temp);
        } while(nextPermutation(arr));


        System.out.println(ans);




    }

    public static int calc(int[] arr) {
        int result=0;
        for (int i = 0; i < arr.length - 1; i++) {
            result += Math.abs(arr[i] - arr[i+1]);
        }

        return result;
    }


    private static boolean nextPermutation(int[] arr) {
        // 오른쪽이 더 큰걸 찾자!
        // 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾음.
        // 2. j >= i 이면서 A[j] > A[i-1]를 만족하는 가장 큰 j를 찾음
        // 3. A[i-1], A[j]를 swap
        // 4. A[i] 부터 순열을 뒤집음

        int i = arr.length - 1;
        int j = arr.length - 1;
        int temp;

        while(i>0 && arr[i-1] >= arr[i])  i--;

        if(i <= 0) return false;

        while(arr[j] <= arr[i-1]) j--;

        temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i<j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }


        return true;
    }
}
