package a01_jichu;
/*
	递归：方法自身调用自身；
			a{
				a();
			}
	
	递归非常耗费栈内存，尽量不使用。

*/

public class DiGui {
	// 主方法
	public static void main(String[] args){
		// 调用doSome方法
		doSome();
	}
	
	public static void doSome(){
		System.out.println("doSome方法begin!");
		doSome();                           // 这行代码不结束，下一行不能执行
		System.out.println("doSome方法over!");
	} 
}

/*
	System.out.println("doSome方法over!"); 没有机会执行！
	程序内存一直执行doSome方法，并不断进行压栈。程序永远不会结束
*/