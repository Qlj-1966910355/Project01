package a01_jichu;
// 自增自减运算符

public class Num1{
	public static void main(String[] args){
		int i = 100;
		System.out.println(i);       // 100
		System.out.println(++i);     // 101
		System.out.println(i);       // 101
		System.out.println(i++);     // 101
// 逻辑与（&）和短路与（&&）的区别
	// &
		System.out.println("与运算前的i =" + i);       // 102
		System.out.println(i == 103 & i<i++);          // false & true
		System.out.println("与运算后的i =" + i);       // 103
		System.out.println("---------------------------------------");
	// &&
		System.out.println("与运算前的i =" + i);      
		System.out.println(i == 104 && i<i++);         // false && true
		System.out.println("与运算后的i =" + i);       // 103
/**
	* 当使用短路与运算（&&）和或运算（||），先判断第一条逻辑表达式，若直接可以判断整体运算结果，则第二条逻辑表达式则不被执行。
	* eg: (103==104 && 103<104) 表达式 （103==104）返回为false,则可以判断整体运算一定返回false。因此，i++并没有执行。
	* 短路或和短路与原理相同。
	* 逻辑与和逻辑或会将所有逻辑表达式执行，再判断整体是否为真。
*/		
		
		
// j++
		int j = 10;
		j++;
		System.out.println(j);       // 11
		int m1 = j++;
		System.out.println(j);       // 12
		System.out.println(m1);      // 11
//++k
		int k = 1;
		++k;
		System.out.println(k);       // 2
		int m2 = ++k;
		System.out.println(k);       // 3
		System.out.println(m2);      // 3
		
	}
}