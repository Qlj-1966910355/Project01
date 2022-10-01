package a01_jichu;
// 格式化输出
	/*	
		* 语法： String.format(字符串指定格式 , 指定字符串)
		* System.out.format(格式,字符串)      <输出>
	*/

// 日期格式化操作
import java.util.Date;                          // 导入java.util.Date类
public class String_2{
	public static void main(String[] args){
		Date date_1 = new Date();
		String date_0 = String.format("%tc",date_1);
		String hour = String.format("%tH",date_1);
		String minute = String.format("%tM",date_1);
		String second = String.format("%tS",date_1);
		String date_2 = String.format("%tF",date_1);
		String date_3 = String.format("%tD",date_1);
		String date_4 = String.format("%tT",date_1);
		
		System.out.println("系统获取时间为："+date_1);
		System.out.println("系统全部时间信息：" + date_0);
		System.out.println("使用format()格式化系统时间，时："+hour);
		System.out.println("使用format()格式化系统时间，分："+minute);
		System.out.println("使用format()格式化系统时间，秒："+second);
		System.out.println("系统时间转换为'年-月-日'格式：" + date_2);
		System.out.println("系统时间转换为'月/日/年'格式：" + date_3);
		System.out.println("%n系统时间转换为'时:分:秒'格式：" + date_4);
		}
}

// 常规类型格式化

class String_3{
	public static void main(String[] args){
		String var_1 = String.format("%d",10/3);
		String var_2 = String.format("%b",3>5);
		String var_3 = String.format("%x",20);
		char num_0 = 12;
		double num_1 = 123.1425;
		String num_2 = String.format("%.2f",num_1);             // 字符型
		System.out.println("format格式化后var_1类型："+getType(var_1));
		System.out.println(var_1);
		System.out.println(var_2);
		System.out.println(var_3);
		System.out.println(num_2 + " 的数据类型是："+getType(num_2));
		System.out.printf("%.2f",num_1);                       // 保留两位小数
		System.out.println("\n"+(double)num_0 + num_1);
		
		}
	public static String getType(Object i){
		return i.getClass().toString();
		}                                                // 查看变量数据类型函数
	}
	
