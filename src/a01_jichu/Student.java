package a01_jichu;
// 创建学生类

// 类体 = 属性 + 方法

/*
需求：
	属性(状态)：姓名；学号；性别；年龄；地区
	方法(动作)：吃饭；上课；学习
*/

/*
	成员变量：实例变量（定义变量未赋值时，默认为0,特殊的String默认为Null，boolean类型默认为false）
*/


// 学生类
public class Student{
	String name;            // 不创建对象，变量的内存空间是不存在的，只有创建了对象变量的内存空间才会创建
	String sno;
	boolean sex;
	int age;
	a01_jichu.Address addr;
	
/*
	// 吃饭
	public static void eat(){
		System.out.println(name + "正在吃饭！");
	}
	// 上课
	public static void course(){
		System.out.println(name + "正在上课！");
	}
	// 学习	
	public static void learn(){
		System.out.println(name + "正在学习！");
	}
*/
}