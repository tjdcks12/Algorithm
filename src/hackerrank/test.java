package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {

    // Complete the equal function below.
    static int equal(int[] arr) {

        int n = arr.length;

        int ans = 0;
        int max = 0;
        int min = 1000;
        int maxIdx = 0;
        int choco;

        while (true) {
            max = 0;
            min = 1000;
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
            if (max == min) break;

            choco = selectChocolate(max, min);
            giveChocolate(maxIdx, choco, arr);
            ans++;
        }
        return ans;
    }

    public static int selectChocolate(int max, int min) {
        int gap = max - min;

        if (gap <= 1) return 1;
        else if (gap > 1 && gap < 5) return 2;
        else return 5;
    }

    public static int[] giveChocolate(int without, int chocolate, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != without) {
                arr[i] += chocolate;
            }
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
