package base;

/**
 * @auther: kid1999
 * @desc:   线段树Java版本
 * @date: 2020/8/21 17:53
 **/


public class SegmentTree {
    private int[] data;   // 原始数据
    private int[] tree;   // 线段树

    public SegmentTree(int[] data) {
        this.data = data;
        tree = new int[data.length*4];     // 线段树为原始数据4倍
        buildTree(0,0,data.length-1);
    }

    // 构建树
    private void buildTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        int mid = (l+r)/2;
        buildTree(leftTreeIndex, l, mid); //先构建两棵子树
        buildTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    // 更新下标为index的值为val
    public void update(int treeIndex, int l, int r,int index,int val){
        if(l == r){
            data[index] = val;
            tree[treeIndex] = val;
            return;
        }
        int mid = (l+r)/2;
        int leftTreeIndex = 2 * treeIndex + 1;
        int rightTreeIndex = 2 * treeIndex + 2;
        if(index >= l && index <= mid){
            update(leftTreeIndex, l, mid,index,val);
        } else{
            update(rightTreeIndex, mid+1, r,index,val);
        }
        // 自底往上更新线段树
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    // 查询 L-R 区域的值的和
    public int query(int treeIndex, int l, int r,int queryL,int queryR){
        System.out.println(l + " " + r);
        if(queryR < l || queryL > r) return 0;
        else if(queryL <= l && r <= queryR) return tree[treeIndex];
        else {
            int mid = l + (r - l) / 2;
            int leftTreeIndex = 2 * treeIndex + 1;
            int rightTreeIndex = 2 * treeIndex + 2;
            int sum_left =  query(leftTreeIndex, l, mid, queryL, queryR);
            int sum_right = query(rightTreeIndex, mid + 1, r, queryL, queryR);
            return sum_left + sum_right;
        }
    }


}
