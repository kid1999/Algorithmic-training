package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/9 9:17
 **/
public class P957 {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,0,0,1};
        System.out.println(826%14);
        System.out.println(prisonAfterNDays(arr,7));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        N = N%14 == 0 ? 14 : N%14;
        for (int j = 1; j <=N ; j++) {
            int[] next = new int[8];
            for (int i = 1; i <=6 ; i++) {
                if(cells[i-1] == cells[i+1]) next[i] = 1;
                else next[i] = 0;
            }
            cells = next;
        }
        return cells;
    }
}
