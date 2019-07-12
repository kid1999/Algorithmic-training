import java.util.Scanner;

public class P1308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aim = sc.nextLine().toLowerCase();
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int start = 0;
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].toLowerCase().equals(aim)){
                count++;
            }
            if (count == 0) start += strs[i].length()+1;
        }
        if (count == 0) System.out.println(-1);
        else System.out.println(count + " " + start);
    }
}
