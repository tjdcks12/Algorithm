package sort3;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};

        sort(arr);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }
    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
