package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/19 11:57
 **/
public class P680 {
    public boolean validPalindrome(String s) {
        int l = 0,r = s.length()-1;
        return func(s,l,r,false);
    }
    boolean func(String s,int l,int r,boolean flag){
        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;r--;
            }else if(!flag){
                flag = true;
                return func(s,l+1,r,flag) || func(s,l,r-1,flag);
            }else{
                return false;
            }
        }
        return true;
    }
}
