package a01_jichu;

public class ChongZai{
	public static void main(String[] args){
		// 不同类型的打印输出（不需要调用系统自带的类）
		U.p(10);
		U.p(false);
		U.p(10.0);
		U.p("awdaw");
		U.p('x');
	}
}


// 方法重载   （方法名相同，形参变量类型不同）
// 自定义类
class U{
	public static void p(byte i){
		System.out.println(i);
	}
	public static void p(short i){
		System.out.println(i);
	}
	public static void p(int i){
		System.out.println(i);
	}
	public static void p(long i){
		System.out.println(i);
	}
	public static void p(float i){
		System.out.println(i);
	}
	public static void p(double i){
		System.out.println(i);
	}
	public static void p(boolean i){
		System.out.println(i);
	}
	public static void p(char i){
		System.out.println(i);
	}
	public static void p(String i){
		System.out.println(i);
	}
}

