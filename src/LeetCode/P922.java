package LeetCode;

import CCPC.test1.A;

import java.util.ArrayList;

/**
 * @author kid1999
 * @date 2020/8/30 10:25
 * @desc
 **/
public class P922 {
    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        sortArrayByParityII(arr);
    }

//    public static int[] sortArrayByParityII(int[] A) {
//        int[] res = new int[A.length];
//        ArrayList<Integer> odd = new ArrayList<>();
//        ArrayList<Integer> even = new ArrayList<>();
//        for (int j = 0; j < A.length; j++) {
//            if(A[j] % 2 == 0){
//                even.add(A[j]);
//            }else {
//                odd.add(A[j]);
//            }
//        }
//        for (int i = 0; i <A.length ; i++) {
//            res[2*i] = even.get(i);
//            res[2*i+1] = odd.get(i);
//        }
//        return res;
//
//    }


    public static int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int odd = -1,even = -1;
        for (int j = 0; j < A.length; j++) {
            if(j % 2 == 0){
                while (even<A.length){
                    even++;
                    if(A[even] % 2 == 0) break;
                }
                res[j] = A[even];
            }else {
                while (odd<A.length){
                    odd++;
                    if(A[odd] % 2 == 1) break;
                }
                res[j] = A[odd];
            }
        }
        return res;
    }
}
