package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/8/8 18:38
 **/
public class P168 {
    // 26进制转换 核心 ---》 n-- 使取模范围在0-25;
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0){
            n--;
            int num = n % 26;
            res.append((char) (num+65));
            n /= 26;
        }
        return res.reverse().toString();
    }
}
