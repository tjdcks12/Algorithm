package sort5;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,1,2,6,9,5,7,8,4};

        mergeSort(arr, 0, arr.length-1);

        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int leftIdx = left;
        int rightIdx = mid+1;
        int sortedIdx = left;

        int[] sortedArr = new int[arr.length];

        while(leftIdx <= mid && rightIdx <= right){
            if(arr[leftIdx]<arr[rightIdx]) {
                sortedArr[sortedIdx++] = arr[leftIdx++];
            } else{
                sortedArr[sortedIdx++] = arr[rightIdx++];
            }
        }
        while(leftIdx <= mid){
            sortedArr[sortedIdx++] = arr[leftIdx++];
        }
        while(leftIdx <= mid){
            sortedArr[sortedIdx++] = arr[rightIdx++];
        }

        for(int i=left;i<sortedIdx;i++){
            arr[i] = sortedArr[i];
        }
    }
}
