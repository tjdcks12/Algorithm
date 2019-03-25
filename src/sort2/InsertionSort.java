package sort2;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};

        sort(arr);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

}
