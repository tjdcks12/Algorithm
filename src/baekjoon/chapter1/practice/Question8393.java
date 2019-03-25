package baekjoon.chapter1.practice;

import java.util.Scanner;

public class Question8393 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result=0;

        for(int i=1;i<=x;i++){
            result+=i;
        }
        System.out.println(result);
    }
}
