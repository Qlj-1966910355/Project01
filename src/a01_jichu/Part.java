package a01_jichu;
/*
	1、常量在整个程序中只能被赋值一次
	2、语法：final 数据类型 常量名称[=值]
	3、常量为全局变量时，必须在定义时赋值
*/

public class Part{
	static final double PI = 3.14;
	static double var_1 = 1.24;
	public static void main(String[] args){
		final double e;
		e = 2.72;
		var_1 = 1.25;
		//e = 2.73;         // final 只能赋值一次
		System.out.println("常量PI的值为：" + PI);
		System.out.println("常量e的值为：" + e);
		System.out.println("double型var_1的值为：" + var_1);
		}
};
