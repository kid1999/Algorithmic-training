package LeetCode;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/2/21 21:24
 **/
public class P542 {
    public static void main(String[] args) {

    }

    public static int[][] updateMatrix(int[][] matrix) {
        int x_len = matrix[0].length;
        int y_len = matrix.length;
        LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
        for (int i=0;i<y_len;i++){
            for (int j=0;j<x_len;j++){
                if(matrix[i][j]==0){
                    queue.add(new Pair<Integer,Integer>(i,j));  	//存入所有包含0的点
                }else{
                    matrix[i][j]=-1;    //初始化  有标记作用
                }
            }
        }

        // 从已经标记的出发 ， -1具有去重的功能
        while (!queue.isEmpty()){
            Pair<Integer,Integer> now = queue.pop();
            int x = now.getValue();
            int y = now.getKey();
            //上
            if(y-1>=0&& matrix[y-1][x]==-1){
                matrix[y-1][x]=matrix[y][x]+1;
                queue.add(new Pair<Integer,Integer>(y-1,x));
            }
            //下
            if(y+1<y_len&&matrix[y+1][x]==-1){
                matrix[y+1][x]=matrix[y][x]+1;
                queue.add(new Pair<Integer,Integer>(y+1,x));
            }
            // 左
            if(x-1>=0&&matrix[y][x-1]==-1){
                matrix[y][x-1]=matrix[y][x]+1;
                queue.add(new Pair<Integer,Integer>(y,x-1));
            }
            //右
            if(x+1<x_len&& matrix[y][x+1]==-1){
                matrix[y][x+1]=matrix[y][x]+1;
                queue.add(new Pair<Integer,Integer>(y,x+1));
            }
        }
        return matrix;
    }
}
