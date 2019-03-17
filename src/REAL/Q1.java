package REAL;

/**
 * Created by Ziv on 2019/3/1.
 */
public class Q1 {

    long getLargestMul(long[] arr) {
        long max1 = 0, max2 = 0, max3 = 0;
        long min1 = 0, min2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                if(arr[i]>max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = arr[i];
                }else if(arr[i]>max2){
                    max3 = max2;
                    max2 = arr[i];
                }else if(arr[i]>max3){
                    max3 = arr[i];
                }else if(arr[i]<min1){
                    min2 = min1;
                    min1 = arr[i];
                }else if(arr[i]>min1 && arr[i]<min2){
                    min2 = arr[i];
                }else {
                    continue;
                }
            }
        }
        return Math.max(max1*(max1*max2),max1*(min1*min2));
    }
}
