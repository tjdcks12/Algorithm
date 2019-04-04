package hackerrank;

import java.util.Scanner;

public class jongchan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        int n;


        for (int i = 0; i < test; i++) {
            n = sc.nextInt();
            int[] arr = new int[n];

            for (int z = 0; z < n; z++) {
                arr[z] = sc.nextInt();
            }

            int ans = 0;
            int max = 0;
            int min = 1000;
            int maxIdx = 0;
            int choco;

            //find max, find min
            for (int j = 0; j < n; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    maxIdx = j;
                }
                if (min > arr[j]) {
                    min = arr[j];
                }
            }

            while (true) {
                choco = selectChocolate(max, min);

                int newMax[] = giveChocolate(maxIdx, choco, arr, max);

                max = newMax[0];
                maxIdx = newMax[1];
                min = min+choco;

                ans++;

                if (max == min) break;

            }
            System.out.println(ans);
        }
    }

    public static int selectChocolate(int max, int min) {
        int gap = max - min;

        if (gap <= 1) return 1;
        else if (gap > 1 && gap < 5) return 2;
        else return 5;
    }

    public static int[] giveChocolate(int without, int chocolate, int[] arr, int max) {
        int newMax = max;
        int newMaxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != without) {
                arr[i] += chocolate;
                if(arr[i]>max) {
                    newMax = arr[i];
                    newMaxIdx = i;
                }
            }
        }

        return new int[] {newMax, newMaxIdx};


    }

}
