package sort7;

public class InsertionSort {

    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int tmp;
            int min = i;
            int j = i-1;

            while(arr[min] > arr[j] && j>=0){
                j--;
            }

            if(j>=0) {
                tmp = arr[i];
                arr[i] = arr[j];
            }

        }
    }
}
