package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/24 10:00
 **/
public class P123 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int n:prices) {
            fstBuy = Math.max(fstBuy,-n);
            fstSell = Math.max(fstSell,fstBuy+n);
            secBuy = Math.max(secBuy,fstSell-n);
            secSell = Math.max(secSell,secBuy+n);
        }
        return secSell;
    }

}
