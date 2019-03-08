package chapter5;

import java.util.Scanner;

public class Question10971 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w[][] = new int[n][n];
        int d[] = new int[n];
        int ans = 4000000;

        for(int i=0;i<n;i++){
            d[i] = i;
        }

        for(int i=0;i<n*n;i++){
            w[i/n][i%n] = sc.nextInt();
        }

        do{
            if(d[0] != 0) break;
            boolean ok = true;
            int sum = 0;
            for(int i=0; i<n-1;i++){
                if(w[d[i]][d[i+1]] == 0) ok = false;
                else sum += w[d[i]][d[i+1]];
            }

            if(ok && w[d[n-1]][d[0]] != 0){
                sum += w[d[n-1]][d[0]];
                if(ans > sum) ans = sum;
            }
        } while(nextPermutation(d));

        System.out.println(ans);





    }

    public static boolean nextPermutation(int arr[]) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while(i>0 && arr[i]<arr[i-1]) i--;

        if(i<=0) return false;

        while(arr[j] <= arr[i-1]) j--;

        int temp;

        temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        j = arr.length-1;

        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
