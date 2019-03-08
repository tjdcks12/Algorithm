package chapter3.normal;

import java.lang.reflect.Array;
import java.util.*;

public class Question1722 {



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int type = sc.nextInt();
        int[] arr = new int[num];
        long[] factorial = new long[num+1];
        boolean[] check = new boolean[num+1];



        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        for(int i=1;i<=num;i++){
            factorial[i] = factorial[i-1]*i;
        }


        if(type == 1){ // where 번째의 순열 출력하기

            int where = sc.nextInt();

            for(int i=0;i<num;i++){
                for(int j=1;j<=num;j++){
                    if(check[j] == true) continue;
                    if(factorial[num-i-1] < where){
                        where -= factorial[num-i-1];
                    } else{
                        arr[i] = j;
                        check[j] = true;
                        break;
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]).append(" ");
            }

            System.out.println(sb.toString());

        } else {
            int result = 0;

            for(int i=0;i<num;i++){
                arr[i] = sc.nextInt();
            }

            for(int i=0;i<num;i++){
                for(int j=1;j<num;j++){
                    if(check[j]==false){
                        result += factorial[num-i-1];
                    }
                }
                check[arr[i]] = true;
            }
            System.out.println(result+1);
        }
    }
}


