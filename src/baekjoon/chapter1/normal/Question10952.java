package baekjoon.chapter1.normal;

import java.util.Scanner;

public class Question10952 {
    public static void main(String[] args){
        int x;
        int y;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            x = sc.nextInt();
            y = sc.nextInt();
            if(x == 0 && y ==0) break;
            System.out.println(x+y);
        }
    }
}
