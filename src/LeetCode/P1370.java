package LeetCode;

/**
 * @author kid1999
 * @create 2020-11-25 20:48
 * @description TODO
 **/
public class P1370 {
    public static void main(String[] args) {

    }

    public String sortString(String s) {
        char[] word = new char[26];
        for (int i = 0; i <s.length() ; i++) {
            word[s.charAt(i) - 'a']++;
        }
        int count = s.length();
        StringBuilder sb = new StringBuilder();
        while (count > 0){
            for (int i = 0; i <26 ; i++) {
                if(word[i] > 0){
                    word[i]--;
                    count--;
                    sb.append((char)(i+'a'));
                }
            }
            for (int i = 25; i >=0 ; i--) {
                if(word[i] > 0){
                    word[i]--;
                    count--;
                    sb.append((char)(i+'a'));
                }
            }
        }
        return sb.toString();
    }
}