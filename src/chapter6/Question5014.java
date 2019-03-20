package chapter6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question5014 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int F = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int G = Integer.parseInt(input[2]);
        int U = Integer.parseInt(input[3]);
        int D = Integer.parseInt(input[4]);

        // F S G U D
        // 총 F층, 목표 층 G, 현재위치 S, U 위로 U만큼, D 아래로 D만큼

        int[] visited = new int[F + 1];
        Arrays.fill(visited, -1);

        System.out.println(BFS(visited, F, S, G, U, D));


    }

    public static String BFS(int[] visited, int F, int S, int G, int U, int D) {

        int next = S;

        Queue<Integer> q = new LinkedList<>();
        q.add(next);
        int[] adjacent = new int[2];
        visited[S] = 0;


        while (!q.isEmpty() && next != G) {
            next = q.poll();

            adjacent[0] = next + U;
            adjacent[1] = next - D;

            for (int i = 0; i < 2; i++) {
                if (adjacent[i] > 0 && adjacent[i] <= F) {
                    if (visited[adjacent[i]] == -1) {
                        q.add(adjacent[i]);
                        visited[adjacent[i]] = visited[next] + 1;
                    }
                }
            }
        }

        if (visited[G] == -1) return "use the stairs";


        return Integer.toString(visited[G]);
    }
}
