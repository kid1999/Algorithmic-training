package LeetCode;

/**
 * @author kid1999
 * @create 2020-10-04 10:26
 * @description TODO
 **/
public class P1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int res = 0;
        for (int i = 0; i <arr1.length ; i++) {
            if(arr1[i] == 1) res += Math.pow(-2,arr1.length-1-i);
        }
        for (int i = 0; i <arr2.length ; i++) {
            if(arr2[i] == 1) res += Math.pow(-2,arr2.length-1-i);
        }
        return new int[10];
    }
}