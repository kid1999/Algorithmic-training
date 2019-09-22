package LuoGu;

import java.util.Scanner;

public class P1101 {
  static char[][] dp;  // 输入二维表
  static boolean[][] flag;  // 标记(染色)数组
  static int[][] func;      // 方向数组
  static char[] aim;        // 目标矩阵
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    aim = new char[]{'y', 'i', 'z', 'h', 'o', 'n', 'g'};
    func = new int[][]{{1, 1}, {1, 0}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
    flag = new boolean[n][n];
    dp = new char[n][n];
    for (int i = 0; i < n; i++) {
      dp[i] = sc.next().toCharArray();
    }
    // 遍历数组  找到一个 ‘y’ 然后 在其周围找到一个 ‘i' 确定这个方向继续DFS 搜索染色
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j] == 'y') {
          for (int k = 0; k < func.length; k++) {
            if (i + func[k][0] >= 0 && i + func[k][0] < dp.length && j + func[k][1] >= 0 && j + func[k][1] < dp.length) {
              if(dp[i + func[k][0]][j + func[k][1]] == 'i' && DFS(i + func[k][0], j + func[k][1], func[k][0], func[k][1], 1)){
                flag[i][j] = flag[i + func[k][0]][j + func[k][1]] = true;   // 满足条件都给染色
              }
            }
          }
        }
      }
    }
    // 输入 被染色的 字母
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (flag[i][j]) System.out.print(dp[i][j]);
        else System.out.print("*");
      }
      System.out.println();
    }
  }
  // 当前位置的坐标 和 行进的 方向 y，x，以及当前是第几个字符
  private static boolean DFS ( int i, int j, int y, int x, int index){
    if (aim[index] != dp[i][j]) return false;
    if (aim[index] == dp[i][j] && index == 6){
      flag[i][j] = true;
      return true;
    }
    boolean tmp = false;
    if (i + y >= 0 && i + y < dp.length && j + x >= 0 && j + x < dp.length) {
      tmp = DFS(i+y, j+x, y, x, index+1);   // 满足条件继续搜索
    }
    if(tmp) flag[i][j] = true;
    return tmp;
  }
}


