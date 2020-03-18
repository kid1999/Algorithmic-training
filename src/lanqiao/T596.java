package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/18 20:01
 **/
public class T596 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for (char c:s.toCharArray()) {
            char word;
            if(c>=97) word = (char) (c-32);
            else word = (char) (c+32);
            System.out.print(word);
        }
    }
}
