package sort;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)){
                int count = map.get(num)+1;
                if(count > nums.length>>1 )
                    return num;
                else
                    map.put(num,count);
            }else{
                map.put(num,1);
            }
        }
        return 0;
    }
}

