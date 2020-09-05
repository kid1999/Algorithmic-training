package nowcoder.bilibili;

/**
 * @author kid1999
 * @date 2020/9/4 9:42
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
//        SpiralMatrix(arr);

//        System.out.println(GetFragment(""));

        int[] arr  = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(GetMaxConsecutiveOnes(arr,2));
    }


    public static int[] SpiralMatrix (int[][] mat) {
        // write code here
        int n = mat.length;
        int m = mat[0].length;
        int x = 0;
        int y = 0;
        int count = 0;
        int num = 0;
        int[] res = new int[n*m];
        while(count < n*m){
            x=num;
            for(y = num;y<m-num;y++){
                res[count++] = mat[x][y];
            }
            if(count >= n*m) break;
            y--;
            for(x = num+1;x<n-num;x++){
                res[count++] = mat[x][y];
            }
            if(count >= n*m) break;
            x--;
            for(y = m-num-2;y>=num;y--){
                res[count++] = mat[x][y];
            }
            if(count >= n*m) break;
            y++;
            for(x = n-num-2;x>=num+1;x--){
                res[count++] = mat[x][y];
            }
            if(count >= n*m) break;
            num++;
        }
        return res;
    }


    public static int GetFragment (String str) {
        // write code here
        if(str.length() < 1) return 0;
        int count = 1;
        int n = 1;
        int sum = 0;
        char last = str.charAt(0);
        for (int i = 1; i <str.length() ; i++) {
            char c = str.charAt(i);
            if(c == last) count++;
            else {
                sum += count;
                n++;
                count = 1;
                last = c;
            }
        }
        sum += count;
        return sum / n;
    }


    public static int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int res = 0;
        int l = 0, r = 0,count = 0;
        while(r<arr.length){
            count += arr[r] == 0 ? 1 : 0;
            while(count > k){
                count -= arr[l++] == 0 ? 1 : 0;
            }
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
