package lanqiao.final2020;

import java.util.Arrays;

/**
 * @author kid1999
 * @create 2020-11-14 18:23
 * @description TODO
 **/
public class E {
    public static void main(String[] args) {
        String s = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhf" +
                "iadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqij" +
                "gihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmad" +
                "vrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
        char[] ss = new char[s.length()];
        int l = 0;
        for (int i = 0; i < s.length() ; i++,l++) {
            ss[l] = s.charAt(i);
            if(l!=0 && ss[l] == ss[l-1]) l--;
        }
        long res = 0;
        int[] dp = new int[l+1];
        for (int i = 1; i <l ; i++) {
            dp[i] = 1;
            for (int j = 0; j <i ; j++) {
                if(ss[j] < ss[i]) dp[i] += dp[j];
                res += dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(res);
    }
}