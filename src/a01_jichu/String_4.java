package a01_jichu;
//用户输入语句

public class String_4{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("请用户输入字符：str_1 = ");
		String str_1 = s.next();                          // 字符串输入
		System.out.println("用户输入内容是：" + str_1 + "\n输入变量的数据类型：" + getType(str_1));
		System.out.print("\n请用户输入数字：num_1 = ");
		int num_1 = s.nextInt();                          // 数字输入
		System.out.println("用户输入数字是：" + num_1 + "\n输入变量的数据类型：" + getType(num_1));
	}

	public static String getType(Object i){
		return i.getClass().toString();                   // 判断数据类型的函数
		}
}