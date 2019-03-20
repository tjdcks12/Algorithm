package chapter7;

import java.util.Scanner;

public class Question9095 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for(int i=0;i<test;i++){
            int goal = sc.nextInt();

            System.out.println((go(0, 0, goal)));
        }
    }

    public static int go(int count, int sum, int goal) {
        int now = 0;

        if(sum > goal) return 0;
        if(sum == goal) return 1;

        for(int i=1;i<=3;i++) {
            now += go(count+1, sum+i, goal);
        }

        return now;

    }
}
