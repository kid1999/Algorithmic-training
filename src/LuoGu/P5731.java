package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-10 23:16
 * @description TODO
 **/
public class P5731 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[15][15];
        int x = 1,y = 0,num = 1;
        while (num<=n*n)
        {
            while(y<n&&a[x][y+1] == 0)a[x][++y]=num++;
            while(x<n&&a[x+1][y] == 0)a[++x][y]=num++;
            while(y>1&&a[x][y-1] == 0)a[x][--y]=num++;
            while(x>1&&a[x-1][y] == 0)a[--x][y]=num++;
        }
        for (int k = 1; k <=n ; k++) {
            for (int l = 1; l <=n ; l++) {
                System.out.printf("%3d",a[k][l]);
            }
            System.out.println();
        }

    }
}



