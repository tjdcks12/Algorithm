package chapter6;
import java.util.HashMap;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;



public class Question1525Web {



    private static Scanner scanner;

    private static int[] dx = { 1, -1, 0, 0 };

    private static int[] dy = { 0, 0, 1, -1 };

    private static Queue<Integer> queue;

    private static int[] dist;

    private static final int MAX = 10001;

    private static String puzzleAns;

    private static HashMap<Integer, Integer> map;



    public static void main(String[] args) {

        // TODO Auto-generated method stub

        scanner = new Scanner(System.in);

        int start = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                int tmp = scanner.nextInt(); // 숫자 넣어주기

                if (tmp == 0)

                    tmp = 9;



                start = start * 10 + tmp; // 자릿수 한 칸씩 이동해야하므로 *10을 해준 것입니다.

            }

        }





        queue = new LinkedList<>();

        map = new HashMap<Integer, Integer>();



        queue.add(start);

        map.put(start,0);

        // 처음 시작 점을 큐에 넣고 이동을 시킨다.

        // 193 / 425 / 786 (이렇게 나눠서 볼 수 있는데 i가 0일땐 193 라인, 1일떈 425 라인, 2일땐 786 라인입니다.

        // j는 각 그룹의 요소들을 접근할 수 있다. 예를들어, i*3+j인데 i가 1이고 j가 2라면 답은 5가 나올 것이다.



        while (!queue.isEmpty()) {

            // 9가 나오는 위치를 찾아서 위치를 찾고 해당 위치를 기준으로 x,y의 위치를 찾는다.

            // x,y의 위치를 찾은 뒤에 그 인덱스로 9의 값을 이동시킨다.

            // 이동시키면서 9가 우측 하단으로 갈 수 있도록 계속해서 swap해준다.



            int nowNum = queue.remove(); // 현재 있는 위치의 숫자 : 193425786

            String now = String.valueOf(nowNum); // 193425786을 문자열로 만든 뒤에 여기서 9를 찾는다.

            int nine = now.indexOf('9'); // 9가 있는 곳의 인덱스를 찾는다.

            int x = nine / 3;

            int y = nine % 3;



            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];

                int ny = y + dy[i];

                if ((nx >= 0 && nx < 3) && (ny >= 0 && ny < 3)) {

                    // 범위 내에 있어야함

                    /*

                     * 이제 해야할 것은 다음 가야할 노드를 찾는다. 3*x + y 일 때의 값과 nx*3 + ny의 값을 위치 변경해줘야합니다.

                     *

                     */

                    StringBuilder next = new StringBuilder(now); // 현재 위치의 문자열 값을 StringBuilder를 통해서 만든다.

                    char temp = next.charAt(x * 3 + y); // 이 전에 있던 것을 temp에 넣어두고 (해당 인덱스가 있는 값임)

                    next.setCharAt(x * 3 + y, (char) next.charAt(nx * 3 + ny)); // nx*3+ny의 인덱스를 갖는 값이 나오게 된다.

                    next.setCharAt(nx * 3 + ny, temp); // nx*3+ny의 인덱스 쪽에 temp(x*3+y)의 인덱스를 갖는 곳의 값을 넣어서 넘겨준다.

                    // 변경하였고 이 next를 queue에 넣어주고 Map의 키에다가도

                    int num = Integer.parseInt(next.toString());

                    if (!map.containsKey(num)) { // 기존에 있던 값이 아닐경우 +1

                        map.put(num, map.get(nowNum) + 1);

                        queue.add(num);

                    }

                }

            }

        }

        if(map.containsKey(123456789)) {

            System.out.println(map.get(123456789));

        }else {

            System.out.println("-1");

        }

    }

}