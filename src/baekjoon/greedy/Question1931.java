package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Question1931 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int[][] timeTable = new int[x][2];
        int endTime = 0;
        int result = 0;

        for(int i=0;i<x;i++){
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }

        Arrays.sort(timeTable,(prev, next) -> prev[1]==next[1] ? prev[0]-next[0] : prev[1]-next[1]); //종료시간이 같을경우에는 시작시간을 기준으로 정렬, 아닐경우 종료시간에 따라 정렬


        for(int i=0;i<x;i++){
            int startTime = timeTable[i][0];
            if(startTime >= endTime){
                endTime = timeTable[i][1];
                result++;
            }
        }

        System.out.println(result);


//        for(int i=0;i<x;i++){
//            System.out.println(i + "번째 타임테이블의 시작시간은 " + timeTable[i][0] + " 종료 시간은 " + timeTable[i][1]);
//        }

    }
}
