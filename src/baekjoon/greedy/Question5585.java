package baekjoon.greedy;

import java.util.Scanner;

public class Question5585 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] yen = {500, 100, 50, 10, 5, 1};
        int count = 0;

        int target = 1000 - sc.nextInt();

        for(int i=0;i<yen.length;i++){
            count += target / yen[i];
            target = target % yen[i];

            if(target == 0) break;
        }

        System.out.println(count);
    }
}
