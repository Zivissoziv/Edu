package NewCoder.Q28;

/**
 * Created by Ziv on 2019/2/13.
 */

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) {
            return null;
        }
        doQuickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void doQuickSort(int[] array, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int pivot = array[start];
            while (i != j) {
                while (i != j && array[j] >= pivot) {
                    j--;
                }
                array[i] = array[j];
                while (i != j && array[i] <= pivot) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = pivot;
            doQuickSort(array,start, i);
            doQuickSort(array,i + 1, end);
        }
    }

    private void quickSort(int[] array, int start, int end) {
        if (end > start) {
            int i = start;
            int j = end;
            int pivot = array[start];
            while (i > j) {
                while (i > j && array[i] < pivot) {
                    i++;
                }
                array[j] = array[i];
                while (i > j && array[j] > pivot) {
                    j--;
                }
                array[i] = array[j];
            }
            array[i] = pivot;
            quickSort(array, start, i);
            quickSort(array, i + 1, end);
        }
    }
}
