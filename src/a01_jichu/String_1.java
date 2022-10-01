package a01_jichu;
// 字符串函数

public class String_1{
	public static void main(String[] args){
		String var_1 = "I love you!";
		String var_2 = "   I love you! ";
		String var_3 = "I love you!";
		String var_4 = new String("I love you!");   // 初始化
// str.length()
		int length_1 = var_1.length();              // 获取字符串长度
// str.indexOf(字符)   获取字符所在的索引位置
		int size_01 = var_1.indexOf("a");           // 获取字符"a"在字符串中的位置，未检索到返回-1
		int size_02 = var_1.indexOf("o");           // 获取字符"o"在字符串中的位置（第一次出现）
		int size_03 = var_1.indexOf("");            // 获取空字符在字符串中的位置
// str.lastindexOf(字符)
		int size_04 = var_1.lastIndexOf("o");       // 获取字符"o"字符在字符串中的位置（最后一次出现）<反向查询>
		int size_05 = var_1.lastIndexOf("");        // 获取空字符在字符串中的位置（与length函数返回一致）
// str.charAt(位置)   获取指定索引位置的字符
		char char_01 = var_1.charAt(5);
		char char_02 = var_1.charAt(var_1.length()-1);         // length返回的是实际长度，而charAt()内是索引位置，因此减1.
// str.substring(开始位置)     截取字符串
		String char_03 = var_1.substring(1);        // 从索引位置1截取到末尾
		String char_04 = var_1.substring(2,6);      // 从索引位置2截取到索引位置5;{截取索引区间[2,6)，不包含6}
// str.trim()       去除两端空格
		String char_05 = var_2.trim();              // 去除字符串var_2前与后的空格   
// str.replace(oldchar,newchar)      替换
		String char_06 = var_1.replace("you","me").replace("I","You");
// str.startsWith(start_char)    判断字符串是否以start_char开始
// str.endsWith(end_char)        判断字符串是否以end_char结尾
		boolean bool_1 = var_1.startsWith("I");     // true
		boolean bool_2 = var_1.endsWith("you");     // false
// 判断字符串是否相等 ① "==";    ② str.equals();    ③ str.equalsIgnoreCase()
		// ==
		boolean bool_3 = (var_1 == var_3);          // true
		boolean bool_4 = (var_1 == var_4);          // false     (相同字符串返回结果不同，原因如下：)
		
		/* var_3与var_1这种创建字符串方式，字符串只在一个内存地址上存储，
		 * 两个变量名指向同一地址，而 ”==“ 号判断时是对两个字符串的地址
		 * 进行比较，因此bool_3返回的是true;
		 * var_4创建字符串时，会直接开辟新的内存地址，字符串相同但底层存
		 * 储的地址不同，因此返回false.
		*/
		// str.equals()           区分大小写
		boolean bool_5 = var_1.equals(var_4);
		
		// str.equalsIgnoreCase()           不区分大小写
		boolean bool_6 = var_1.toLowerCase().equalsIgnoreCase(var_4);
// 转换大小写
		// str.toUpperCase()          转换为大写        
		// Str.toLowerCase()          转换为小写
		String char_07 = var_1.toUpperCase();
		String char_08 = var_1.toLowerCase();
// str.split()           字符串分割          (分割后是多个字符串，所以用数组存储)
		String array_1[] = var_1.split(" ");    // 用空格进行分割
		String array_2[] = var_1.split(" ",2);     // 分割(n-1)次

// -------------------输出-----------------------		
		System.out.println("var_1：" + var_1);
		System.out.println("var_2：" + var_2);
		System.out.println("var_2：" + var_3);
		System.out.println("var_2：" + var_4);
		System.out.println("\nvar_1的字符串长度：" + length_1);
		System.out.println("\n\"a\"在字符串var_1中的位置：" + size_01);
		System.out.println("\"o\"在字符串var_1中的位置：" + size_02);
		System.out.println("\"\"在字符串var_1中的位置：" + size_03);
		System.out.println("\n\"o\"在字符串var_1中最后一次出现的位置：" + size_04);
		System.out.println("\"\"在字符串var_1中的位置(从后向前查询)：" + size_05);
		System.out.println("\n字符串var_1中位置为5的字符为：" + char_01);         // 索引位置依然是从0开始查找
		System.out.println("字符串var_1中位置为12的字符为：" + char_02);
		System.out.println("\n截取字符串var_1从1~-1：" + char_03);
		System.out.println("截取字符串var_1从2~6：" + char_04);
		System.out.println("\n去除var_2字符串前与后的字符串为：" + char_05);
		System.out.println("\n将字符串var_1中\"I\"替换为\"You\",\"you\"替换为\"me\"：" + char_06);
		System.out.println("\n判断字符串var_1是否以\"I\"开始：" + bool_1);
		System.out.println("判断字符串var_1是否以\"you\"结尾：" + bool_2);
		System.out.println("\n① 判断字符串var_1与var_3是否相等：" + bool_3);
		System.out.println("   用==判断字符串var_1与var_4是否相等：" + bool_4);
		System.out.println("② 用equals()判断字符串var_1与var_4是否相等：" + bool_5);
		System.out.println("③ 用equalsIgnoreCase()判断字符串var_1与var_4.toLowerCase()是否相等：" + bool_6);
		System.out.println("\n将字符串var_1转换为大写：" + char_07);
		System.out.println("将字符串var_1转换为小写：" + char_08);
		System.out.print("将字符串var_1用\" \"分割：");
		for (String char_09:array_1){
			System.out.print("["+char_09+"]");
			}                                   // 遍历分割时产生的数组array_1
		System.out.print("\n将字符串var_1用\" \"分割：");
		for (String char_10:array_2){
			System.out.print("["+char_10+"]");
			}                                   // 遍历分割时产生的数组array_2
		
		
		
		
		}

}


/* 
	* 字符串中首字符是以0开始，结尾为-1.(注意大小写)
	* str.indexOf() 返回指定字符首次出现的位置
	* 检索字符串中不存在的字符返回值为-1.
	* 检索字符为空时，返回0.
	
	* str.lastIndexOf() 从后向前检索首次出现的字符位置。
	* 检索字符为空时，返回效果与length()函数一致，返回字符串长度



*/