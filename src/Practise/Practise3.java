package Practise;

/**
 * Created by Ziv on 2019/3/15.
 * 快排
 */
public class Practise3 {
    public static void main(String[] args) {
        int[] a = new int[]{8, 9, 4, 1, 23, 7, 6, 1};
        Practise3 p3 = new Practise3();
        p3.quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int i = start;
            int j = end;
            int pivot = arr[start];
            while (i != j) {
                while (i != j && arr[j] >= pivot) {
                    j--;
                }
                arr[i] = arr[j];
                while (i != j && arr[i] <= pivot) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = pivot;
            quickSort(arr, start, i);
            quickSort(arr, i + 1, end);
        }
    }
}

