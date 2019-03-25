package baekjoon.chapter1.normal;

import java.util.Scanner;

public class Question10951 {
    public static void main(String[] args){
        int x;
        int y;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            x = sc.nextInt();
            y = sc.nextInt();
            System.out.println(x+y);
        }
    }
}
