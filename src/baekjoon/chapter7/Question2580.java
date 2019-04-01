package baekjoon.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question2580 {

    public static final int size = 9;
    public static int[][] arr;

    public static List<int[]> list;
    public static boolean isEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        arr = new int[size][size];
        list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        // 입력 완료
        backtracking(0);

    }

    public static void backtracking(int idx) {
        // 결과가 나왔다면 조회할 필요가 없다.
        if (isEnd) return;

        // 인덱스가 list크기를 넘어가면 종
        if (idx >= list.size()) {
            isEnd = true;
            print();
            return;
        }


        int y = list.get(idx)[0];
        int x = list.get(idx)[1];

        // 1 부터 9 까지 입력 가능한 숫자 를 확인한다.
        for (int i = 1; i <= 9; i++) {
            // 해당 숫자가 가능하면 해당 좌표에 값을 입력하고 backtracking을 한다.
            if (isAble(y, x, i)) {
                System.out.println(idx + "인덱스의 백트랙킹 수행중");

                arr[y][x] = i;
                backtracking(idx + 1);
                arr[y][x] = 0;
            } else{
                System.out.println(idx + "인덱스의 백트랙킹 수행중 적합하지 않은값 들어옴");

            }
        }

    }

    public static void print() {
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean isAble(int y, int x, int v) {
        for (int i = 0; i < size; i++) {
            // 가로가 유효한지 arr[y][x]의 값이 가로에 또 존재하면 안된다.
            if (arr[y][i] == v) return false;

            // 세로가 유효한지 arr[y][x]의 값이 세로에 또 존재하면 안된다.
            if (arr[i][x] == v) return false;
        }

        // 3*3이 유효한지
        int y_s = y / 3 * 3;
        int x_s = x / 3 * 3;
        for (int i = y_s; i < y_s + 3; i++) {
            for (int j = x_s; j < x_s + 3; j++) {
                if (arr[i][j] == v) return false;
            }
        }
        return true;
    }
}
