package a01_jichu;

// 递归	1~10累加
public class DiGui1{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("输入数字：");
		int num_1 = s.nextInt();
		int result = sum(num_1);
		System.out.println("结果输出：" + result);
	}
	
	// 累加方法
	public static int sum(int i){
		if(i == 1){
			return 1;
		}
		i = i + sum(i-1);
		return i;
		}
}