package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/24 9:49
 **/
public class P122 {

    // 贪心
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length < 2) return 0;
        for (int i = 1; i <prices.length ; i++) {
            if(prices[i] > prices[i-1]) res += prices[i]-prices[i-1];
        }
        return res;
    }
}
