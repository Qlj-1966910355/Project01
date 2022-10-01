package a01_jichu;

// 递归方法实现n！(阶乘)
public class DiGui2{
	public static void main(String[] args){
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("输入数字：");
		int num_1 = s.nextInt();                  // 输入数字
		int result = mult(num_1);                 // 调用mult()方法
		System.out.println("结果输出：" + num_1 + "!=" + result);
	} 
	
	// 阶乘方法
	public static int mult(int i){
		if(i == 1){
			return 1;
		}
		return i * mult(i-1);
	}
}