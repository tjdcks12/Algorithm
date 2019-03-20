package linecodetest;


import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long min = Long.MAX_VALUE;

        for(int i=1;i<=a;i++){
            if(a%i == 0){
                if(Math.abs(i - (a/i)) < min) {
                    min = Math.abs(i - (a/i));
                }
            }
        }

        System.out.println(min);


    }
}
