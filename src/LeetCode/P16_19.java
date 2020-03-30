package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/30 12:11
 **/
public class P16_19 {

    static int[] func;
    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        func = new int[]{-1,-1,-1,0,-1,1,0,-1,0,1,1,-1,1,0,1,1};
        for (int i = 0; i <land.length ; i++) {
            for (int j = 0; j <land[0].length ; j++) {
                if(land[i][j] == 0){
                    int sum = dfs(land,i,j);
                    res.add(sum);
                }
            }
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int[] result = new int[res.size()];
        for (int i = 0; i <res.size() ; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static int dfs(int[][] land,int i,int j){
        if(i<0||j<0||i>=land.length||j>=land[0].length||land[i][j]!=0) return 0;
        land[i][j] = 1;
        int sum = 1;
        for (int k = 0; k <8 ; k++) {
            sum += dfs(land,i+func[2*k],j+func[2*k+1]);
        }
        return sum;
    }
}
