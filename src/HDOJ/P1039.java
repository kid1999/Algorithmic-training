package HDOJ;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-19 19:57
 * @description TODO
 **/
public class P1039 {
    static HashSet set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        while (true){
            String s = sc.nextLine();
            if(s.equals("end")) return;
            if(judge(s)) System.out.printf("<%s> is acceptable.%n",s);
            else System.out.printf("<%s> is not acceptable.%n",s);
        }
    }
    public static boolean judge(String s){
        boolean f = false;
        int x = 0,y = 0;
        char last = '0';
        for(char c:s.toCharArray()){
            if (set.contains(c)){
                f = true;
                x++;
                y = 0;
            }else{
                y++;
                x = 0;
            }
            if(x >= 3 || y>=3) return false;
            if(c == last && c != 'e' && c != 'o') return false;
            else last = c;
        }
        return f;
    }
}