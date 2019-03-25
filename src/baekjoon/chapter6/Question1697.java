package baekjoon.chapter6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1697 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int root = sc.nextInt();
        int target = sc.nextInt();
        int[] check = new int[200000];

        Arrays.fill(check, -1); // 초기값 모두 -1로 ( int로 지정한이유는 depth마다 count+ 해주기 위함)

        System.out.println(BFS(root, target, check));

    }

    public static int BFS(int root, int target, int[] check) {
        int nextRoot = root;
        int[] adjacent = new int[3];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nextRoot);
        check[root] = 0;

        while(!q.isEmpty() && nextRoot != target) {
            nextRoot = q.poll();

            adjacent[0] = nextRoot-1;
            adjacent[1] = nextRoot+1;
            adjacent[2] = nextRoot*2;

            for(int i=0;i<3;i++) {
                if(adjacent[i] >= 0 && adjacent[i] <= 100000) {
                    if(check[adjacent[i]] == -1) {
                        q.add(adjacent[i]);
                        check[adjacent[i]] = check[nextRoot] + 1;
                    }
                }
            }
        }
        return check[target];
    }

}
