package nowcoder.weimob;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/6 15:47
 * @desc
 **/

class test1{
    static void test(){
        System.out.println("....");
    }
}

class tets2 extends test1{
    static void test(){
        System.out.println("hello");
    }
    static void test(String s){

        System.out.println(s);
    }
}

public class Main {
    public static void main(String[] args) {
        tets2.test();
        tets2.test("sdasd");
        System.out.println(func("/a/b/c/d/aaa.txt","/a/b/c/1/2/bbb.text"));
    }

    public static String func(String a,String b){
        int len = 0;
        String[] as = a.split("/");
        String[] bs = b.split("/");
        for(int i=0;i<bs.length;i++){
            if(bs[i].equals(as[i])){
                len++;
            }else break;
        }
        int l1 = as.length - len;   // a长
        int l2 = l1 - (bs.length - len);    // b
        String res = "";
        for(int i=1;i<l2;i++){
            res += "../";
        }
        res += bs[bs.length-1];
        return res;
    }

    public static String[] sortMethod (String[] stringArray) {
        // write code here
        Arrays.sort(stringArray,(a,b)->{
            String[] s1 = a.split("\\.");
            String[] s2 = b.split("\\.");
            for (int i = 0; i <s1.length ; i++) {
                int a1 = Integer.parseInt(s1[i]);
                int b1 = Integer.parseInt(s2[i]);
                if(a1 > b1) return -1;
                else if(a1 < b1) return 1;
            }
            return 0;
        });
        return stringArray;
    }


    public static String reverseWord (String str) {
        // write code here
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <strings.length ; i++) {
            String s = strings[i];
            if(i == strings.length-1){
                if(s.charAt(s.length()-1) == '.'){
                    sb.append(new StringBuffer(s.substring(0,s.length()-1)).reverse()).append(".");
                }else {
                    sb.append(new StringBuffer(s).reverse());
                }
            }else {
                sb.append(new StringBuffer(s).reverse()).append(" ");
            }
        }
        return sb.toString();
    }

    public static long sum (long n) {
        // write code here
        if(n == 1) return 1;
        else return n + sum(n-1);
    }
}
