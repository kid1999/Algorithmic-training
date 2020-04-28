package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/28 9:05
 **/
public class PM56_1 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;        // 两数异或之和
        for (int n:nums) {
            sum ^= n;
        }
        int first = 1;
        while ((sum&first) == 0){   // 用第一个异或为1 划分两个数的集合
            first <<= 1;
        }
        int[] res = new int[2];
        for (int n:nums) {
            if((n&first) == 0) res[0] ^= n;
            else res[1] ^= n;
        }
        return res;
    }
}
