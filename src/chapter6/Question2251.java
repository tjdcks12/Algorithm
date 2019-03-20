package chapter6;

import java.util.*;


public class Question2251 {

    static class Water {
        Water(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int a;
        int b;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();//A용량
        int b = scan.nextInt();//B용량
        int C = scan.nextInt();//C용량 -> 총 물의 합

        Queue queue = new LinkedList<>();
        queue.add(new Water(0, 0));
        List arr = new ArrayList<>();
        boolean[][] check = new boolean[a + 1][b + 1];
        check[0][0] = true;

        while (!queue.isEmpty()) {
            Water water = (Water)queue.poll();
            int x = water.a;
            int y = water.b;
            int c = C - x - y;
            if (x == 0) {
                arr.add(c);
            }

            //x -> y,x
            if (x > 0) {
                //x->y
                int avail = x + y <= b ? x : b - y;//옮길수있는 물의양
                if (check[x - avail][y + avail] != true) {
                    queue.add(new Water(x - avail, y + avail));
                    check[x - avail][y + avail] = true;
                }
                //x->c , C보다 클 일은 없음
                if (check[0][C - x - c] != true) {
                    queue.add(new Water(0, C - x - c));
                    check[0][C - x - c] = true;
                }
            }

            //y->x,c
            if (y > 0) {
                //y->x
                int avail = x + y <= a ? y : a - x;
                if (check[x + avail][y - avail] != true) {
                    queue.add(new Water(x + avail, y - avail));
                    check[x + avail][y - avail] = true;
                }
                //y->c
                if (check[x][0] != true) {
                    queue.add(new Water(x, 0));
                    check[x][0] = true;
                }
            }

            //c -> x,y
            if (c > 0) {
                //c->x
                int avail = c + x <= a ? c : a - x;
                if (check[x + avail][C - x - c] != true) {
                    queue.add(new Water(x + avail, C - x - c));
                    check[x + avail][C - x - c] = true;
                }

                //c->y
                avail = c + y <= b ? c : b - y;
                if (check[x][y + avail] != true) {
                    queue.add(new Water(x, y + avail));
                    check[x][y + avail] = true;
                }
            }


        }
        Collections.sort(arr);
        for (
                int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
    }



}