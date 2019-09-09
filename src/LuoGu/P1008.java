package LuoGu;

import java.util.ArrayList;
import java.util.List;

public class P1008 {
    public static void main(String[] args) {
        List<Character> nums = new ArrayList<>();
        for (int i = 123; i <= 333; i++) {
            for (char num:String.valueOf(i).toCharArray()){
                if (nums.contains(num)){
                    break;
                }
                nums.add(num);
            }

            for (char num:String.valueOf(i*2).toCharArray()){
                if (nums.contains(num)){
                    break;
                }
                nums.add(num);
            }

            for (char num:String.valueOf(i*3).toCharArray()){
                if (nums.contains(num)){
                    break;
                }
                nums.add(num);
            }
            if (nums.size() == 9 && !nums.contains('0'))
                System.out.printf("%d %d %d\n",i,i*2,i*3);
            nums.clear();
        }

    }
}
