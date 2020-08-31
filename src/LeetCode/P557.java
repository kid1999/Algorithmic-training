package LeetCode;

/**
 * @author kid1999
 * @date 2020/8/30 10:17
 * @desc
 **/
public class P557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String ss:strings) {
            sb.append(new StringBuffer(ss).reverse() + " ");
        }
        return sb.toString().trim();
    }
}
