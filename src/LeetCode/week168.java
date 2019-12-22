package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/22 10:28
 **/
public class week168 {
    public static void main(String[] args) {
        int[] arr = {3,3,2,2,1,1};
//        System.out.println(isPossibleDivide(arr,3));
        System.out.println(maxFreq("aaaa",1,3,3));
    }

    // 1
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num:nums) {
            String n = String.valueOf(num);
            if(n.length() % 2 == 0) res++;
        }
        return res;
    }

    // 2
    public static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k != 0) return false;
        Arrays.sort(nums);
        int[][] arr = new int[100005][2];
        int count = 0;
        int last = 0;
        arr[0][0] = nums[0];
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == nums[last]){
                arr[count][1]++;
            }else{
                count++;
                arr[count][0] = nums[i];
                arr[count][1]++;
            }
            last = i;
        }
        int min = 0;
        int sum = 0;
        while (sum < nums.length){
            for (int i = min; i <k+min ; i++) {
                arr[i][1]--;
                sum++;
            }
            int new_min = min;
            int pre = arr[min][0] -1;
            for (int i = 0; i <k ; i++) {
                if(arr[min+i][1] < 0 || pre +1 != arr[min+i][0]) return false;
                if(arr[min+i][1] == 0 ) new_min++;
                pre = arr[min+i][0];
            }
            min = new_min;
        }
        return true;
    }

    // 3
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = minSize; i <=maxSize ; i++) {
            for (int j = 0; j <s.length()-i; j++) {
                String findText = "";
                for (int k = 0; k <i ; k++) {
                    set.add(s.charAt(k+j));
                    findText += s.charAt(k+j);
                }
                if(set.size() > maxLetters){
                    set.clear();
                    continue;
                }
                set.clear();
                if(findText.length() == i){
                    int count = 0;
                    Pattern p = Pattern.compile(findText);
                    Matcher m = p.matcher(s);
                    while (m.find()) {
                        count++;
                    }
                    System.out.println(findText + " " + count);
                    if(count>res) res = count;
                }
            }
        }
        return res;
    }



    // 4
}
