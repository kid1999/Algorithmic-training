package lanqiao;

public class D {
  public static void main(String[] args) {
    int res = 0;
    boolean[][] flag = new boolean[2020][2020];
    for(int i=1;i<2019;i++) {
      for(int j=1;j<2019;j++) {
        if(i+j>=2019) break;
        int c = 2019-i-j;
        if(isGoodNum(c) && isGoodNum(i) && isGoodNum(j) && i!=j && i!=c && j!=c) {
          if(!flag[i][j] && !flag[i][c]) {
            res++;
            flag[i][j] = true;
            flag[j][i] = true;
            flag[i][c] = true;
            flag[c][i] = true;
            flag[j][c] = true;
            flag[c][j] = true;
            System.out.println(i + " " + j +" " + c);
          }
        }
      }
    }
    System.out.println(res);
  }

  public static boolean isGoodNum(int n) {
    while(n>10) {
      int num = n%10;
      n/=10;
      if(num==2||num==4) return false;
    }
    if(n==2||n==4) return false;
    return true;
  }
}
