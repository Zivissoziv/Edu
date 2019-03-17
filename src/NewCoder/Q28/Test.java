package NewCoder.Q28;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/2/13.
 */
public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> integers = sl.GetLeastNumbers_Solution(new int[]{1, 3, 5, 7, 9, 2, 4}, 4);
        System.out.println(integers.toString());
    }

}
