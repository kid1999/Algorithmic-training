package lanqiao;

public class C {

  public static void main(String[] args) {
    int a = 1;
    int b = 1;
    int c = 1;
    int n = 20190324;
    for(int i=3;i<n;i++) {
      int tmp = (a+b+c)%100000;
      a = b;
      b = c;
      c = tmp;
    }
    System.out.println(c);
  }

}
