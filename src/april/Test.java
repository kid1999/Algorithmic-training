package april;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> window = new ArrayDeque<>();   // 双向队列
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new int[nums.length-k+1];
        if (nums == null) return;
        for (int i = 0; i < nums.length; i++) {
            if(i>=k && window.getFirst() <= i-k){
                 window.pollFirst();
            }
            while (!window.isEmpty() &&  nums[window.getLast()] <= nums[i] ){
                window.pollLast();
            }
            window.add(i);
            if(i>=k-1)
                res[i-k+1] = nums[window.getFirst()];
        }
        System.out.println(res);

    }
}
