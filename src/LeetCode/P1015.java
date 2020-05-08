package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/8 9:39
 **/
public class P1015 {
    public int smallestRepunitDivByK(int K) {
        if(K%2 == 0 || K%5 == 0) return -1;
        int len = 1;
        int num = 1;
        while (num%K != 0){
            num %= K;
            num = num*10+1;
            len++;
        }
        return len;
    }
}
