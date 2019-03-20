package line;

import java.util.HashMap;
import java.util.Map;

public class Question1 {


    public static void main(String[] args){

        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        long start = System.currentTimeMillis(); //시작하는 시점 계산
        solution(v);
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000000.0 +"초");

    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();



        for(int i=0;i<3;i++){
            //mapX 채우기
            if(mapX.containsKey(v[i][0])){
                mapX.put(v[i][0], mapX.get(v[i][0])+1);
            } else {
                mapX.put(v[i][0], 1);
            }

            //mapY 채우기
            if(mapY.containsKey(v[i][1])){
                mapY.put(v[i][1], mapY.get(v[i][1])+1);
            } else {
                mapY.put(v[i][1], 1);
            }
        }

        int idx = 0;
        for(Integer key : mapX.keySet()){
            if(mapX.get(key) == 1){
                answer[0] = key;
            }
        }

        for(Integer key : mapY.keySet()){
            if(mapY.get(key) == 1){
                answer[1] = key;
            }
        }


        return answer;
    }
}
