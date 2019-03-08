package chapter4.practice;

import java.util.Scanner;

public class Question1476Remain {

    public static void main(String[] args){
        final int E = 15;
        final int S = 28;
        final int M = 19;

        Scanner sc = new Scanner(System.in);

        int inputE = sc.nextInt();
        int inputS = sc.nextInt();
        int inputM = sc.nextInt();
        int year = 1;

        while(true) {
            int ee = ((year - 1) % E) + 1;
            int ss = ((year - 1) % S) + 1;
            int mm = ((year - 1) % M) + 1;

            if(ee == inputE  && ss == inputS  && mm == inputM){
                System.out.println(year);

                break;
            }
            year++;
        }

    }
}
