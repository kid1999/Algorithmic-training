package lanqiao.test2020;

public class E {
	/**
	 * 全部按逆序排列的交换次数为 N! 且此时最短
	 * 多余的交换次数 通过 交换首字母与后面的某元素进行减少
	 * 如：交换 1 --> 2 1
	 *    交换 3 --> 3 2 1
	 *    交换 5 --> 4 3 2 1
	 *
	 *  .....
	 *  交换(105) 16 15 14 ....
	 *  交换100 --> 13 15 14 16 12 .......
	 *  对应字符即可
	 */
	public static void main(String[] args) {
		func();
	}
	static void func(){
		int n = 0;
		int lay = 1;
		while (n < 100) {
			System.out.println(n);
			 n += lay;
			 lay++;
		}
		System.out.println(n);
		System.out.println(lay);
	}
	
}
