package a01_jichu;
// while循环

public class XunHuan1{
	public static void main(String[] args){
		int x = 1;
		int sum = 0;
		while(x <= 100){
			sum = sum + x;
			x++;
			}
		System.out.println("1+~~+100 = " + sum);
	}
}



// do~~while循环 （先执行do语句块；循环至少被执行一次）

class XunHuan2{
	public static void main(String[] args){
		int x = 1;
		int sum = 0;
		while(x <= 50){
			sum = sum + x;
			x++;
			}
		do{
			sum = sum + x;
			x++;
			}
		while(x <= 100);                // 注：while结束加分号。
		
		System.out.println("1+~~+100 = " + sum);
	}
}



// for循环              语法：for(表达式1;表达式2;表达式3){循环块}
/*
	for循环执行时，首先执行表达式1，对循环递增变量进行初始化；
								 然后判断表达式2，若为真，则执行循环块内语句；
								 循环执行1次后执行表达式3，进行递增/减，然后再执行表达式2进行判断进入循环。

无限循环：for(;;){循环体}            退出时只能用break退出循环。

*/

class XunHuan3{
	public static void main(String[] args){
		int sum = 0;
		for(int x = 1;x <= 100;x++){
			sum = sum + x;
			if(x == 101){
				break;
				}
			}
		System.out.println("1+~~+100 = " + sum);
		}
}

// for循环遍历数组
class XunHuan4{
	public static void main(String[] args){
		int array_1[] = {1,2,3,4,5};                //声明一维数组
		for (int x : array_1){
			System.out.println(x);
			}
		}
	}

/*
	break与continue一般与if一起使用。
	break :退出循环体
	continue:跳出本次循环
	
	 				 标签名:(一般两个循环嵌套在一起时，内层循环不能直接退出所有循环，
 				 				 可以对最外层循环添加标签，在内层循环执行break/continue 标签名)
 				 				 
							语法：      标签名:循环体{ break/continue 标签名;}
*/