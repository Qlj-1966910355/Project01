package a01_jichu;
// switch 语句

// 需求：两个整数之间的四则运算

public class LianXi_2{
	public static void main(String[] args){
		System.out.println("---------------简单整数计算器--------------");
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请输入第一个数字：");
		int num_1 = s.nextInt();
		
		System.out.print("请输入运算符：");
		String var_1 = s.next();
		
		System.out.print("请输入第二个数字：");
		int num_2 = s.nextInt();
		
		int result = 0;
		switch(var_1){
			case "+":
				result = num_1 + num_2;
				break;
				
			case "-":
				result = num_1 - num_2;
				break;
				
			case "*":
				result = num_1 * num_2;
				break;
				
			case "/":
				result = num_1 / num_2;
				break;
				
			default:
				System.out.println("无效计算！");
		}
		System.out.println(num_1 + " " + var_1 + " " + num_2 + " = " + result);	// 结果输出
		
		
		
		
		String var_2 = "" + num_1 + num_2;        // 测试两个数字进行连接输出不做加法运算
		System.out.println(var_2);
		System.out.println("" + num_1 + num_2);
	}
} 