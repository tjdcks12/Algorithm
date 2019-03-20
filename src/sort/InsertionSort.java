package sort;

public class InsertionSort {

    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};

        for(int i=1;i<arr.length;i++){

            int key = arr[i];
            int j = i-1;

            while(j>=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }


}
