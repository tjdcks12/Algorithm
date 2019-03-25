package baekjoon.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2580web {
    public static int map[][] = new int[9][9];
    public static int size;
    public static int[] horizontal = new int[9], vertical = new int[9], div = new int[9];
    public static ArrayList<Elements> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int i, j, num, divNum;

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                map[i][j] = num = sc.nextInt();
                divNum = (i / 3) * 3 + (j / 3);

                if (map[i][j] == 0) list.add(new Elements(i, j, divNum));
                else {
                    vertical[i] |= (1 << num);
                    horizontal[j] |= (1 << num);
                    div[divNum] |= (1 << num);
                }
            }
        }

        size = list.size();
        dfs(0);
    }

    public static void dfs(int pos) {
        if (pos > size - 1) {
            print();

            return;
        }
        int num, x, y, divNum, check;

        for (num = 1; num <= 9; num++) {
            x = list.get(pos).x;
            y = list.get(pos).y;
            divNum = list.get(pos).divNum;

            if (isPossible(pos, num)) {
                check = 1 << num;

                map[x][y] = num;
                div[divNum] |= check;
                vertical[x] |= check;
                horizontal[y] |= check;

                dfs(pos+1);

                map[x][y] = 0;
                div[divNum] &= ~check;
                vertical[x] &= ~check;
                horizontal[y] &= ~check;

            }
        }
    }

    private static boolean isPossible(int pos, int num) {
        int check = 1 << num;

        if ((div[list.get(pos).divNum] & check) == check || (vertical[list.get(pos).x] & check) == check || (horizontal[list.get(pos).y] & check) == check)
            return false;

        return true;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(map[i][j]+ " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static class Elements {
        int x, y, divNum;

        public Elements(int x, int y, int divNum) {
            this.x = x;
            this.y = y;
            this.divNum = divNum;
        }
    }
}


