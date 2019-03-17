package NewCoder.Q48;

/**
 * Created by Ziv on 2019/2/21.
 */
public class Q48 {

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
}

class test{
    public static void main(String[] args) {
        Q48 q48 = new Q48();
        int[] res = q48.multiply(new int[]{4,3,2,5 });
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
