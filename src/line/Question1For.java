package line;

import java.util.HashMap;
import java.util.Map;

public class Question1For {
    public static void main(String[] args){

        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        long start = System.currentTimeMillis(); //시작하는 시점 계산
        solution(v);
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");

    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        int x, y;

        if(v[0][0] == v[1][0]) {
            x = v[2][0];
        } else{
            if(v[1][0] == v[2][0]){
                x = v[0][0];
            } else{
                x = v[2][0];
            }
        }

        if(v[0][1] == v[1][1]) {
            y = v[2][1];
        } else{
            if(v[1][1] == v[2][1]){
                y = v[0][1];
            } else{
                y = v[2][1];
            }
        }

        answer[0] = x;
        answer[1] = y;

        System.out.println(answer[0]);
        System.out.println(answer[1]);


        return answer;
    }
}
