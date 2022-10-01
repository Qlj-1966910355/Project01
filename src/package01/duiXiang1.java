package package01;

public class duiXiang1 {
    public static void main(String[] args){
        // 基本数据类型（局部变量）
        int i = 1;       // 保存在栈内存中
        // 引用数据类型
        String j = "like";    // String 是JDK提供的类，不需要new运算符实例化。

        // 对象1<实例化>（引用数据类型）
        Student var_1 = new Student();          // 实例化后的对象保存在堆内存中，其中实例化后的实例变量也在堆内存中。
        // var_1被称作“引用”。它存储在栈内存中（局部变量），但变量所保存的是指向对象所在的位置的地址。

        System.out.println("姓名：" + var_1.name);        // 默认为null
        System.out.println("学号：" + var_1.sno);        // 默认为null
        System.out.println("性别：" + var_1.sex);        // 默认为false
        System.out.println("年龄：" + var_1.age);        // 默认为0

        // 实例化address类（注：var_1-->Student-->address 引用指向顺序）
        var_1.addr = new Address();                      // Student类中定义了address类的引用。使用address类需要实例化。
        System.out.println("地区（省）：" + var_1.addr.sf);        // 默认为null
        System.out.println("地区（市）：" + var_1.addr.sq);        // 默认为null
        System.out.println("地区（县）：" + var_1.addr.xj);        // 默认为null
        System.out.println("地区（镇）：" + var_1.addr.xz);        // 默认为null

        System.out.println("-----------------------------------------");
        // 对象2
        Student var_2 = new Student();

        // 修改实例变量
        var_2.name = "屈刘杰";
        var_2.sno = "17100305107";
        var_2.sex = true;
        var_2.age = 23;

        // 实例化address类
        var_2.addr = new Address();
        var_2.addr.sf = "陕西省";
        var_2.addr.sq = "渭南市";
        var_2.addr.xj = "蒲城县";
        var_2.addr.xz = "尧山镇";


        System.out.println("姓名：" + var_2.name);        // 屈刘杰
        System.out.println("学号：" + var_2.sno);        // 17100305107
        System.out.println("性别：" + var_2.sex);        // true
        System.out.println("年龄：" + var_2.age);        // 23
        System.out.println("籍贯：" + var_2.addr.sf + var_2.addr.sq + var_2.addr.xj + var_2.addr.xz);
    }
}

/*
内存存储：
	1、类加载：将程序涉及的类加载到“方法区内存”中，其中主要包括（String.class、duiXiang1.class、Student.class、address.class）
	2、加载方法：将方法及局部变量存储在“栈内存”中，并对局部变量数据存储。
	3、实例化：String类创建和Student类创建生成对象，保存在“堆内存”当中，并为对象内的实例变量分配内存。
*/

/*
	注：
		1、var_1只是一个局部变量（栈内存），new Student()才是真正的对象。
		2、在java中只能通过“引用”的方式取访问堆内存中对象内部的实例变量。
		3、访问实例变量：
										引用.实例变量              eg：var_1.name
		4、修改实例变量：<只针对当前对象。创建其他对象后还是以Student类中的实例变量值为准>
										引用.实例变量 = 值         eg：var_1.name = "屈刘杰"

*/

