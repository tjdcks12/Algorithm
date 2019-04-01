package sort6;

public class QuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        int left = l;
        int right = r;
        int pivot = arr[(left + right) / 2];

        do {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }

        } while (left <= right);

        if(l<right) quickSort(arr, l, right);
        if(left < r) quickSort(arr, left, r);

    }

}
