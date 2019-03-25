package sort3;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {3,1,2,6,9,5,7,8,4};

        quickSort(arr, 0, arr.length-1);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }
    public static void quickSort(int[] arr, int l, int r){
        int left = l;
        int right = r;
        int pivot = arr[(l+r)/2];

        do{
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }while(left <= right);

        if(l < right) quickSort(arr, l, right);
        if(left < r) quickSort(arr, left, r);
    }
}
