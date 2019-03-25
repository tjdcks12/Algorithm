package baekjoon.greedy;

import java.util.Scanner;

public class Question2217 {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        int x = sc.nextInt();
        int[] arr = new int[x];

        for(int i=0;i<x;i++){
            arr[i] = sc.nextInt();
        }
        sort(arr);

        long weight = arr[0];
        int k = 1;

        for(int i=1;i<arr.length;i++){
            k++;
            if(arr[i] * k > weight) weight = arr[i] * k;
            else continue;
        }

        System.out.println(weight);
    }















    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] <= key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] =  key;
        }
    }
}
