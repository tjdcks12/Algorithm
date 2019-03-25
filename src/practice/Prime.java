package practice;

import java.util.Scanner;

public class Prime {

    public static boolean[] prime;
    public static void main(String[] args){

        prime = new boolean[100000];


        notPrime(prime);

        for(int i=0;i<prime.length;i++){
            if(prime[i] == false){
                System.out.println(i);
            }
//            System.out.print("값" + i + "는 소수가 " + (prime[i] == true ?"아닙니다" : "맞습니다") );

//            System.out.println();
        }
    }

    public static boolean[] notPrime(boolean[] arr){
        int size = arr.length;
        for(int i=2;i<Math.sqrt(size);i++){
            for(int j=i*i;j<size;j+=i){
                arr[j] = true;
            }
        }
        return arr;
    }
}
