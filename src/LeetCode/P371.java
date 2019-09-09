package kid1999.io;

public class P371 {

	public static void main(String[] args) {
		System.out.println(getSum(20,30));
	}
 public static int getSum(int a, int b) {
	    int res = 0;
	    int f = 0;
	    for(int i=0;i<32;i++){
	      int x = a&1;
	      int y = b&1;
	      a>>=1;
	      b>>=1;
	      res += ((x+y+f)%2)<<i;
	      if(x+y+f >=2) f = 1;
	      else f = 0;
	    }
	    return res;
	  }
}
