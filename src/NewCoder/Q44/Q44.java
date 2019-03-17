package NewCoder.Q44;

/**
 * Created by Ziv on 2019/2/18.
 * 输入数组代表牌组，如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class Q44 {
    public boolean isContinuous(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        int king = 0;
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                king++;
            } else if (numbers[i + 1] - numbers[i] - 1 <= king) {
                king -= numbers[i + 1] - numbers[i] - 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int pivot = array[start];
            while (i < j) {
                while (i < j && array[j] >= pivot) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && array[i] <= pivot) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = pivot;
            quickSort(array, start, i);
            quickSort(array, i + 1, end);
        }
    }
}

class test {
    public static void main(String[] args) {
        Q44 q44 = new Q44();
        System.out.println(q44.isContinuous(new int[]{1, 3, 0, 7, 0}));
    }
}
