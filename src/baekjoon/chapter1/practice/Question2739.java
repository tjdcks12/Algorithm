package baekjoon.chapter1.practice;

import java.util.Scanner;

public class Question2739 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        for(int i=1; i<10; i++){
            System.out.println(new StringBuilder().append(x).append(" * ").append(i).append(" = ").append(x*i).toString());
        }
    }
}
