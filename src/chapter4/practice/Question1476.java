package chapter4.practice;

import java.util.Scanner;

public class Question1476 {

    public static void main(String[] args){

        final int E = 15;
        final int S = 28;
        final int M = 19;
        int ee = 1;
        int ss = 1;
        int mm = 1;
        int result = 1;

        Scanner sc = new Scanner(System.in);

        int inputE = sc.nextInt();
        int inputS = sc.nextInt();
        int inputM = sc.nextInt();

        for(int i=0;i<E*S*M;i++){

            if(ee == inputE  && ss == inputS  && mm == inputM){
                System.out.println(result);
                break;
            }

            ee++;
            ss++;
            mm++;

            if(ee == E+1) ee = 1;
            if(ss == S+1) ss = 1;
            if(mm == M+1) mm = 1;

            result++;

        }
    }
}
