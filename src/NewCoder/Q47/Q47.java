package NewCoder.Q47;

/**
 * Created by Ziv on 2019/2/20.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Q47 {
    public int duplicate(int numbers[]) {
        if (numbers.length < 2) {
            return -1;
        }

        int i = 0;
        while (i < numbers.length-1) {
            while (numbers[i] == i) {
                i++;
                if(i==numbers.length){
                    return -1;
                }
            }
            if (numbers[i] == numbers[numbers[i]]) {
                return numbers[i];
            } else {
                int tmp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = tmp;
            }
        }
        return -1;
    }
}

class test{
    public static void main(String[] args) {
        Q47 q47 = new Q47();
        int duplicate = q47.duplicate(new int[]{});
        System.out.println(duplicate);
    }
}
