package chapter1.practice;

import java.util.Scanner;

public class Question10818 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int max=-1000000;
        int min=1000000;
        int temp;

        for(int i=0;i<x;i++){
            temp = sc.nextInt();
            if(max < temp) max = temp;
            if(min > temp) min = temp;
        }
        System.out.println(min);
        System.out.println(max);
    }
}
