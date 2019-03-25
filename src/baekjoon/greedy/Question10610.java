package baekjoon.greedy;

import java.util.Scanner;

public class Question10610 {

    public static final int MAX = 100000;

    public static String str;
    public static int[] numCountArr;
    public static long strLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        strLen = str.length();
        numCountArr = new int[10];
        long total = 0;
        for (int i = 0; i < strLen; i++) {
            int tNum = Integer.parseInt(str.substring(i, i + 1));
            numCountArr[tNum] += 1;
            total += tNum;
        }

        // 0이 존재하지 않으면 30 배수 조차도 될 수 없다.
        // 각 자리수의 총 합이 3의 배수가 아니면 종료해야한다.
        if (!str.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (numCountArr[i] > 0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}


//    static boolean find = false;
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String x = sc.nextLine();
//
//        int[] arr = new int[x.length()];
//        for(int i=0;i<x.length();i++){
//            arr[i] = x.charAt(i) - '0';
//        }
//
//        sort(arr);
//
//        if(getNum(arr)%30 == 0) {
//            find = true;
//            System.out.println(getNum(arr));
//        }
//
//        while(find==false){
//            if(nextPermutation(arr) == false) break;
//        }
//
//
//
//    }
//
//    public static boolean nextPermutation(int[] arr) {
//        int i=arr.length-1;
//        int j=arr.length-1;
//        int tmp;
//
//        int result = 0;
//
//        while(i>0 && arr[i] > arr[i-1]) i--;
//        if(i<=0) {
//            System.out.println(-1);
//            return false;
//        }
//
//        while(arr[i-1] <= arr[j]) j--;
//
//        tmp = arr[i-1];
//        arr[i-1] = arr[j];
//        arr[j] = tmp;
//
//        j = arr.length-1;
//        while(i<j) {
//            tmp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = tmp;
//            i++;
//            j--;
//        }
//        if(getNum(arr)%30 == 0) {
//            System.out.println(find);
//            find = true;
//            System.out.println(getNum(arr));
//        }
//        return true;
//    }
//
//    public static int getNum(int[] arr){
//        int result = 0;
//        for(int z=0;z<arr.length;z++){
//            result = result*10 + arr[z];
//        }
//        return result;
//    }
//
//
//
//    public static void sort(int[] arr){
//        for(int i=0;i<arr.length-1;i++){
//            int min = i;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[min] < arr[j]) min = j;
//            }
//            int temp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = temp;
//        }
//    }
