package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/14 12:44
 **/
public class P1300 {
    public static void main(String[] args) {
        int[] arr = {15,1,1,1,1,1,1,1,1,1,1,1};
//        System.out.println(findBestValue(arr,50));
    }

//    public int findBestValue(int[] arr, int target) {
//        int sum = 0, len = arr.length;
//        Arrays.sort(arr);
//        int l = 0;
//        int res = Integer.MAX_VALUE;
//        int value = 0;
//        for (int cast = 0; cast < 100001; cast++) {
//            if (l<len && arr[l] == cast){
//                sum += arr[l++];
//            }
//            int count = sum + (len - l) * cast;
//            if (Math.abs(target - count) < res) {
//                res = Math.abs(target - count);
//                value = cast;
//            }
//        }
//        return value;
//    }


    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int avg = target / n;

        // 对于[1,2,2]，target=10的这种情况
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        if (max < avg) {
            return max;
        }

        // 记录前一轮的差值
        int pre = Integer.MAX_VALUE;
        // 从平均值开始遍历
        for (int i = avg; ; ++i) {
            // 记录每轮的总和
            int sum = 0;
            for (int value : arr) {
                sum += Math.min(value, i);
            }
            // 比较差值，看前一个点是否是最小值
            if (Math.abs(sum - target) >= pre) {
                return i - 1;
            }
            // 更新差值记录
            pre = Math.abs(sum - target);
        }
    }

}
