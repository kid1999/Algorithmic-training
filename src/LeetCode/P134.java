package LeetCode;

/**
 * @author kid1999
 * @create 2020-11-18 18:05
 * @description TODO
 **/
public class P134 {
    public static void main(String[] args) {

    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        for (int i = 0; i <n ; i++) {
//            int sum = 0;
//            for (int j = 0; j <n ; j++) {
//                sum += gas[(i+j)%n] - cost[(i+j)%n];
//                if(sum < 0) break;
//            }
//            if(sum >= 0) return i;
//        }
//        return -1;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length,need = 0,has = 0,k = 0;
        for (int i = 0; i <n ; i++) {
            need += (gas[i] - cost[i]);
            has += (gas[i] - cost[i]);
            if(need < 0){
                need = 0;
                k = i+1;
            }
        }
        return has >= 0 ? k : -1;
    }
}