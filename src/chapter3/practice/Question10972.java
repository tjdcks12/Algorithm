package chapter3.practice;

import java.util.Scanner;

public class Question10972 {

    private int[] arr;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int arr[] = new int[x];

        for(int i=0;i<x;i++){
            arr[i] = sc.nextInt();
        }

        if(!nextPermutation(arr)){
            System.out.println("-1");
        }

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
        StringBuilder result = new StringBuilder();

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

        for(int x=0;x<arr.length;x++){
            result.append(arr[x]).append(" ");
        }

        System.out.println(result.toString());


        return true;
    }
}
