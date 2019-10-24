package lanqiao;

import javafx.util.Pair;

import java.util.*;

public class G {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int t = sc.nextInt();
    int[][] dp = new int[n+1][2];
    List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    for (int i = 0; i <m ; i++) {
      int ts = sc.nextInt();
      int id =  sc.nextInt();
      if(ts<=t) {
        Pair<Integer, Integer> pair = new Pair<>(ts, id);
        pairs.add(pair);
      }
    }
    pairs.sort(new Comparator<Pair<Integer,Integer>>() {
      @Override
      public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
        return o1.getKey() - o2.getKey();
      }
    });

    boolean[] flag = new boolean[n+1];
    for(Pair<Integer,Integer> pair:pairs){
      int ts = pair.getKey();
      int id = pair.getValue();
      dp[id][1] -= (ts-dp[id][0] == 0 ? 0 : ts-dp[id][0]-1);
      if(dp[id][1]<=0) dp[id][1] = 0;
      dp[id][1] += 2;
      if(dp[id][1] > 5) flag[id] = true;
      if(dp[id][1] <= 3) flag[id] = false;
      dp[id][0] = ts;
    }
    // 清算
    int res = 0;
    for(int id=1;id<=n;id++){
      dp[id][1] -= t-dp[id][0];
      if(dp[id][1] <= 3) flag[id] = false;
      if(flag[id]) res++;
    }
    System.out.println(res);
  }
}
