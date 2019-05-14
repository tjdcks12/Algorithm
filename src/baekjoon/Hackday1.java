package baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class Hackday1 {

    public static int solution(int[] A){
        int min = 200;
        int ans = 0;

        for(int target = 1;target<=6;target++){
            for(int i=0;i<A.length;i++){
                if(A[i] != target){
                    if(A[i] + target ==7) ans+=2;
                    else ans++;
                }
            }

            if(min > ans) min = ans;
            ans = 0;
        }

        System.out.println(min);

        return 0;
    }

    public static void main(String[] args){
        int[] a = {1,6,2,3};
        solution(a);
    }

}