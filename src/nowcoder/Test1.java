package nowcoder;

import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/4 9:23
 * @desc
 **/
public class Test1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        String sp = strs[0];
        String dp = strs[1];
        String string = strs[2];
        String[] strings = string.split(sp);
        System.out.println(strings.length);
        for(String ss:strings) {
            String[] res = ss.split(dp);
            System.out.print(res[0] + " ");
            System.out.println(res[1]);
        }
    }
}
