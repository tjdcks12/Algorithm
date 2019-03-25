package baekjoon.greedy;

import java.util.*;
public class Question11047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        int[] value = new int[N];


        for(int i=0;i<N;i++) {
            value[i] = sc.nextInt();
        }

        int idx = N-1;
        while(K!=0 && idx>=0){
            int a = K / value[idx];
            if(a==0) {
                idx--;
                continue;
            } else{
                K =  K % value[idx];
                idx--;
                count += a;
            }
        }

        System.out.println(count);

    }
}
