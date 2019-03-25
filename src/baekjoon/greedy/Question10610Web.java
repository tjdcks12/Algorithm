package baekjoon.greedy;

import java.util.Scanner;

public class Question10610Web {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        int digitTotal = 0;
        int[] digit = new int[10];

        for(int i=0;i<num.length();i++){
            digitTotal += num.charAt(i)-'0';
            digit[num.charAt(i)-'0']++;
        }




        if(num.contains("0") && digitTotal%3==0){
            for(int i=9;i>=0;i--){
                while(digit[i]>0) {
                    System.out.print(i);
                    digit[i]--;
                }
            }
        } else{
            System.out.println("-1");
        }

    }
}
