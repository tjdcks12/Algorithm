package chapter6;

import java.util.*;

public class Question1525 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int start = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int tmp = sc.nextInt();
                if(tmp == 0) tmp = 9;
                start = start * 10 + tmp;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        map.put(start, 0);





        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //좌우로 움직이면서 파악

        while(!queue.isEmpty()) {

            int nowNum = queue.poll();
            String numStr = Integer.toString(nowNum);


            int nineIndex = numStr.indexOf('9');
            int xIndex = nineIndex/3;
            int yIndex = nineIndex%3;

            for (int i = 0; i < 4; i++) {
                int nx = xIndex + dx[i];
                int ny = yIndex + dy[i];

                if ((nx >= 0 && nx < 3) && (ny >= 0 && ny < 3)) {
                    StringBuilder next = new StringBuilder(numStr);

                    char tmp = next.charAt(3 * nx + ny);
                    next.setCharAt(3 * nx + ny, next.charAt(nineIndex));
                    next.setCharAt(nineIndex, tmp);

                    int nextNum = Integer.parseInt(next.toString());

                    if(!map.containsKey(nextNum)) {

                        map.put(nextNum, map.get(nowNum) + 1);
                        queue.add(nextNum);
                    }
                }
            }
        }


        if(map.containsKey(123456789)){
            System.out.println(map.get(123456789));
        }
        else{
            System.out.println(-1);
        }



    }
}
