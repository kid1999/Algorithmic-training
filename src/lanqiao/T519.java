package lanqiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/18 20:32
 **/
public class T519 {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i <n ; i++) {
            int num = 0;
            for (int j = 0; j <m ; j++) {
                num = (num << 1) + sc.nextInt();
            }
            arr[i] = num;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i <n ; i++) {
            map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i])+1 : 1);
        }
        for (Map.Entry<Integer,Integer> set: map.entrySet()) {
            int key = set.getKey();
            int value = set.getValue();
            int max = (1<<m) - 1;
            int num = (~key) & max;     // 按位取反
            if(map.containsKey(num)){
                res += value * map.get(num);
            }
        }
        System.out.println(res / 2);
    }
}
