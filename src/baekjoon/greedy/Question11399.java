package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question11399 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int[] arr= new int[x];
        int[] wait = new int[x];
        int result = 0;

        for(int i=0;i<x;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        wait[0] = arr[0];

        for(int i=1;i<x;i++){
            wait[i] = wait[i-1] + arr[i];
        }

        for(int i=0;i<x;i++){
            result += wait[i];
        }



        System.out.println(result);
    }
}
