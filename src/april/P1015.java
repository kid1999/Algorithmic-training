package april;

import java.util.Scanner;

public class P1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String n = sc.next();
        String[] sum = new String[1];
        sum[0] = n;
        int i;
        for (i = 0; i <= 30; i++) {
            String num1 = sum[0];
            String num2 = new StringBuffer(num1).reverse().toString();
            if(num1.equals(num2)){
                break;
            }
            else {
                StringBuffer str  = new StringBuffer();
                int flag = 0;
                int cha = 0;
                for (int j = num1.length()-1; j >=0; j--) {
                    if(num1.charAt(j) - 'A' >= 0){
                        cha +=7;
                    }
                    if(num2.charAt(j) - 'A' >= 0){
                        cha +=7;
                    }
                    int add = (int)(num1.charAt(j)+num2.charAt(j) - '0' - '0') - cha;
                    cha = 0;
                    if(flag == 1) {
                        add += 1;
                    }
                        if (add >= m){
                            str.append(res_num(add-m));
                            flag = 1;
                        }else{
                            str.append(res_num(add));
                            flag = 0;
                        }

                }
                if(flag == 1){
                    str.append(1);
                }
                sum[0] = str.reverse().toString();
            }
        }
        if(i > 30) System.out.println("Impossible!");
        else System.out.println("STEP=" + i);
    }

    public static String res_num(int num){
        switch (num){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: return String.valueOf(num);
            case 10: return "A";
            case 11: return "B";
            case 12:return "C";
            case 13:return "D";
            case 14:return "E";
            case 15:return "F";
        }
        return "";
    }
}
