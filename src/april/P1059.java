package april;


import java.util.*;

public class P1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }



        List<Integer> arr = new LinkedList<>();
        arr.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = arr.size()-1; j >=0 ; j--) {
                int a = arr.get(j);
                if(tmp>a) {
                    arr.add(j+1, tmp);
                    break;
                }
                if (a == tmp) break;
                if(j==0) arr.add(0,tmp);
            }
        }


        System.out.println(arr.size());
        for (int a:arr) {
            System.out.print(a + " ");
        }

    }
}
