package a01_jichu;//复合语句（块语句）  符号：“{}”

public class Compound{
	static int y;
	public static void main(String[] args){
		int x = 20;
		System.out.println(y);
		{
			y = 40;
			System.out.println(y);
			int z = 245;
			boolean b;
			{
				b = y > z;
				System.out.println(b);
			}
		}
		String word = "hello java";
		System.out.println(word);
		System.out.println(y);
	}
}
/*
输出：
0
40
false
hello java
40
*/