package LeetCode;

import java.util.*;

public class week159 {
  public static void main(String[] args) {
    int[][] arr = new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
//    System.out.println(checkStraightLine(arr));

    // 2
//    String[] folder = {"/a/b/c","/a/b/d","/a/b/ca"};
//    System.out.println(removeSubfolders(folder));

    // 3
    System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));
  }

  // 1
  public static boolean checkStraightLine(int[][] coordinates) {
    int[] node = coordinates[0];
    if((coordinates[1][0] - node[0]) == 0){
      for (int i = 2; i <coordinates.length ; i++) {
        if(coordinates[i][0] != node[0]) return false;
      }
      return true;
    }
    double k = (double) (coordinates[1][1] - node[1]) / (coordinates[1][0] - node[0]);
    for (int i = 1; i <coordinates.length ; i++) {
      if(coordinates[i][0] - node[0] == 0) return false;
      double new_k = (double) (coordinates[i][1] - node[1]) / (coordinates[i][0] - node[0]);
      if(k != new_k) return false;
      node = coordinates[i];
    }
    return true;
  }

  // 2
  public static List<String> removeSubfolders(String[] folder) {
    Set<String> set = new HashSet<>();
    List<String> reslut = new ArrayList<>();
    Arrays.sort(folder, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if(o1.length() > o2.length()) return 1;
        else if(o1.length() == o2.length())  return 0;
        else return -1;
      }
    });

    for (int i = 0; i <folder.length ; i++) {
      String res = "";
      boolean f = true;
      String[] list = folder[i].split("/");
      for(int j=1;j<list.length;j++){
        res =  res + "/" + list[j];
        if(set.contains(res)){
          f = false;
          break;
        }
      }
      if(f){
        set.add(folder[i]);
        reslut.add(folder[i]);
      }
    }
    return reslut;
  }

  // 3
  public static int balancedString(String s) {
    int[] nums = new int[4];
    for(char c:s.toCharArray()){
      if(c == 'Q') nums[0]++;
      if(c == 'W') nums[1]++;
      if(c == 'E') nums[2]++;
      if(c == 'R') nums[3]++;
    }
    int res = 0;
    int avg = s.length()/4;
    for (int i = 0; i <4 ; i++) {
      if(nums[i] > avg) res += nums[i]-avg;
    }
    return res;
  }


  // 4
  public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int[] dp = new int[startTime.length+1];
    for (int i = 0; i <startTime.length ; i++) {
      dp[i] = profit[i];
      for (int j = 0; endTime[j] <= startTime[i] ; j++) {
        dp[i] = Math.max(dp[i],dp[j-1]+profit[i]);
      }
    }
    return dp[startTime.length-1];
  }
}
