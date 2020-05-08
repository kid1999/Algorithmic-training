package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/8 10:13
 **/
public class P233 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(10));
    }
//    假设第i位上的数字为x的话
//    1.如果x > 1的话，则第i位数上包含的1的数目为：(高位数字 + 1）* 10 ^ (i-1) (其中高位数字是从i+1位一直到最高位数构成的数字)
//    2.如果x < 1的话，则第i位数上包含的1的数目为：(高位数字 ）* 10 ^ (i-1)
//    3.如果x == 1的话，则第i位数上包含1的数目为：(高位数字) * 10 ^ (i-1) +(低位数字+1) (其中低位数字时从第i - 1位数一直到第1位数构成的数字)

    public static int countDigitOne(int n) {
        if(n <= 0) return 0;
        int high = n;
        int i = 1;
        int sum = 0;
        while(high != 0){
            high = (int)(n / Math.pow(10 , i));  //高位数（最高位到i+1位组成的）
            int temp = (int) (n / Math.pow(10 , i - 1));
            int cur = temp % 10;  //当前位
            int low = (int) (n  - temp * Math.pow(10, i - 1));//low表示当前位的低位（i-1位到最低位组成）
            if(cur > 1){
                sum += (high + 1) * Math.pow(10 , i - 1);
            }else if(cur < 1){
                sum += high * Math.pow(10 , i - 1);
            }else{
                sum += high * Math.pow(10 , i - 1);
                sum += low + 1;
            }
            i++;
        }
        return sum;
    }

}
