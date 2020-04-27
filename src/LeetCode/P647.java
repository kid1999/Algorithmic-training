package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/27 9:33
 **/
public class P647 {
    public int countSubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int l=i-1,r=i+1;
            res++;
            while (l>=0 && r<chars.length){
                if(chars[l] == chars[r]){
                    l--;r++;res++;
                }else break;
            }
            l=i;r=i+1;
            while (l>=0 && r<chars.length){
                if(chars[l] == chars[r]){
                    l--;r++;res++;
                }else break;
            }
        }
        return res;
    }
}
