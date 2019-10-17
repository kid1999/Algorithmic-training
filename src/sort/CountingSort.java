package sort;

public class CountingSort {
  public static void main(String[] args) {
    int[] arr = {1,3,5,4,7,8,6,9,2,2,3,1};
    CountSort(arr,1,10);
    for (int i = 0; i <arr.length ; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  // 针对某个范围数据的排序 如：（1-10）
  public static void CountSort(int[] arr,int min,int max){
    // tmp数组的大小 == max - min
    int[] tmp = new int[max-min+1];
    int cur = 0;
    for (int i = 0; i <arr.length ; i++) tmp[arr[i]]++;
    for (int i = 0; i <=max-min ; i++) {
      while (tmp[i] != 0) {
        arr[cur++] = i;
        tmp[i]--;
      }
    }
  }
}
