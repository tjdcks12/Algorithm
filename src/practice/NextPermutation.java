package practice;

public class NextPermutation {

    public static void main(String[] args){
        int[] x = {1,2,3};

        do{
            for(int i=0;i<x.length;i++){
                System.out.print(x[i]);
            }
            System.out.println();
        }
        while(nextPermutation(x));
    }

    public static boolean nextPermutation(int[] arr){
//        int i = arr.length-1;
//        int j = arr.length-1;
//
//        while(i>0 && arr[i]>arr[i-1]) i--;
//
//        if(i<=0) return false;
//
//        while(arr[i-1] <= arr[j]) j--;
//
//        int tmp = arr[i-1];
//        arr[i-1] = arr[j];
//        arr[j] = tmp;
//
//        j = arr.length-1;
//
//        while(i>j){
//            tmp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = tmp;
//            i++;
//            j--;
//        }

        int i = arr.length - 1;
        int j = arr.length - 1;
        int temp;
        StringBuilder result = new StringBuilder();

        while(i>0 && arr[i-1] >= arr[i])  i--;

        if(i <= 0) return false;

        while(arr[j] <= arr[i-1]) j--;

        temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i<j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return true;
    }

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
//        return true;
//    }
}
