package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @author kid1999
 * @date 2020/9/17 22:48
 * @title Java结构体排序
 */

// 对结构体排序
class Node implements Comparable<Node>{

	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 先按 x 排序 再按 y排序
	@Override
	public int compareTo(Node other) {
		if(other.x > this.x) return 1;
		else if(other.x < this.x) return -1;
		else {
			return other.y - this.y;
		}
	}
}




public class NodeSort {
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		list.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.x-o2.x;
			}
		});
	}


}
