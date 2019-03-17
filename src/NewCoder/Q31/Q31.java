package NewCoder.Q31;

/**
 * Created by Ziv on 2019/2/14.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Q31 {
    public String PrintMinNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.valueOf(numbers[i] + ""+numbers[j]);
                int b = Integer.valueOf(numbers[j] + ""+numbers[i]);
                if (a > b) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        String res = "";
        for (int number : numbers) {
            res += number;
        }
        return res;
    }
}

class test {
    public static void main(String[] args) {
        Q31 q31 = new Q31();
        System.out.println(q31.PrintMinNumber(new int[]{1,2,4,56,3}));
    }
}
