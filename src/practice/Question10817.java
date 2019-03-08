package practice;

import java.util.Scanner;

public class Question10817 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];
        int temp;


        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        for(int i=0; i<3-1; i++){
            for(int j=i+1;j<3;j++){
                if(arr[i] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(arr[1]);
    }
}
