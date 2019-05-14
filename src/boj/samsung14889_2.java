package boj;

import java.util.Scanner;

public class samsung14889_2 {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][] map = new int[21][21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);
        System.out.println(ans);

    }

    public static void dfs(int v, int len) {
        if(len == n/2) {
            divideTeam();
        } else {

            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(i, len+1);
                }
            }
        }
        visited[v] = false;
    }

    public static void divideTeam() {
        int[] a = new int[n/2+1];
        int[] b = new int[n/2+1];
        int ai = 1;
        int bi = 1;

        for(int i=1;i<=n;i++){
            if(visited[i]){
                a[ai++] = i;
            } else{
                b[bi++] = i;
            }
        }

        int aStat = getStat(a);
        int bStat = getStat(b);

        int result = Math.abs(aStat-bStat);

        if(ans>result) {
            ans = result;
        }
    }

    public static int getStat(int[] arr) {
        int result = 0;
        int len = n/2;

        for(int i=1;i<=len;i++){
            for(int j=i+1;j<=len;j++)
            {
                result += map[arr[i]][arr[j]];
                result += map[arr[j]][arr[i]];
            }

        }
        return result;

    }
}
