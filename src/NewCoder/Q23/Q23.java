package NewCoder.Q23;

/**
 * Created by Ziv on 2019/2/10.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Q23 {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if ( sequence==null || sequence.length<=0 ) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }

    private static boolean VerifySquenceOfBST(int [] sequence, int start, int end){
        if ( start>=end )
            return true;

        int root = sequence[end];

        //左指针移动至中央
        int i=start;
        while( sequence[i] < root ){
            i++;
        }

        //右指针移动至最后
        int j=i;
        while( j<end ){
            if ( sequence[j]<root ) {
                return false;
            }
            j++;
        }

        boolean left = VerifySquenceOfBST(sequence, start, i-1);
        boolean right = VerifySquenceOfBST(sequence, i, end-1);
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{1,2,3,4,5,6,7,8,9,11}));
    }
}
