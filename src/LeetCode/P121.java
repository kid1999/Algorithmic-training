package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/24 9:22
 **/
public class P121 {
    public static void main(String[] args) {

    }

    // 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int n:prices) {
            if(n<min) min = n;
            if(n-min > max) max = n-min;
        }
        return max;
    }
}
