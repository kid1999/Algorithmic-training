package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/1/16 15:12
 **/
public class P43 {
    public static void main(String[] args) {

    }


    public String multiply(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        if(len1 < 0 || len2 < 0) return "";
        int[] nums = new int[len1+len2+2];

        for (int i = len1; i >=0 ; i--) {
            for (int j = len2; j >=0 ; j--) {
                int bit = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                bit += nums[i+j+1];
                nums[i+j] += bit/10;
                nums[i+j+1] = bit%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i<nums.length-1 && nums[i] == 0) i++;
        for (int j = i; j <nums.length ; j++) {
            sb.append(nums[j]);
        }
        return sb.toString();
    }
}
