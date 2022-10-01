package a01_jichu;

//整数、字符类型
public class Num{                       // public class 的类名必须与文件名一致
	
	public static void main(String[] args){
		byte mybyte = 125;
		short myshort = 32765;
		int myint = 21454975;
		long mylong = 3100000000L;                // 数字大于int型的最大或小于int型的最小值，数字后加l/L
		float myfloat = 1.1f;                     // 使用float型，在数字后加f/F
		double mydouble = 2.2;                    // 使用double型，数字后加d/D，不加不报错
		double result = mybyte + myshort + myint + mylong + myfloat + mydouble;  //类型范围最大是double型，因此求和后值为double型
		System.out.println(result);
		}
};
class	A{
		public static void main(String[] args){
			char mychar1 = 'a',mychar2 = 'b';
			int myint1 = 235,myint2 = 236;
			System.out.println("a在unicode表中的位置：" + (int)mychar1);
			System.out.println("b在unicode表中的位置：" + (int)mychar2);
			System.out.println("unicode表中第235位：" + (char)myint1);
			System.out.println("unicode表中第236位：" + (char)myint2);
			}
}

class	B{
		public static void main(String[] args){
			char var_1 = '\\';
			char var_2 = '\u2605';
			System.out.println("双斜线表示字符：" + var_1 + "\n4位16进制数据\'2605\'表示字符：" + var_2);
			}
};

// 