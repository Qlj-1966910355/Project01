package package02;

/**
 * 面向对象三大特征：
 *   封裝
 *   继承
 *   多态
 * */

/**
 * 以下代码存在的问题：
 *  Student类中的属性在外部程序可以随意进行访问，导致学生信息不安全；
 *  年龄信息出现负值，但用户年龄不应该出现负值，程序存在漏洞。
 *
 * 封装机制
 *  问：为什么要封装？封装有什么好处？
 *      1、封装之后，对于被封装的事物来说，看不到这个事物的复杂一面，只能看到事物的简单一面。
 *      2、提高程序的可复用性和可维护性
 *      3、将对象的私有数据与公共数据分离，保护私有数据，减少了可能的模块间干扰，降低程序复杂性、提高可控性的目的
 *
 *
 * 访问类属性的形式
 *  1、读取：get
 *  2、修改：set
 *
 *
 * 封装步骤
 *  1、所有属性私有化，使用private关键字进行修饰，private表示私有的，修饰的所有数据只能在本类中访问
 *  2、对外提供简单的操作入口，要想访问私有属性，必须通过简单的入口进行访问。
 *      对外提供两种公开的方法：
 *              (1) get() 获取方法
 *                  命名规范：
 *                      public 返回类型 get属性名(){
 *                          return 属性名;
 *                      }
 *
 *                  eg:
 *                      public String getName(){
 *                          return getName;
 *                      }

 *              (2) set() 修改方法
 *                  命名规范：
 *                      public void set属性名(实参类型 实参变量){
 *                          属性名 = 实参变量;
 *                      }
 *
 *                  eg:
 *                      public void setNeme(string a){
 *                          name = a;
 *                      }
 *              注：1、这两个方法与普通方法不同之处：
 *                  封装所使用的set()与get()方法中不需要static进行修饰
 *
 *                  2、调用方法
 *                     * 有static时的方法（普通方法）调用语法：类名.方法名(实参);
 *                     * 没有static时的方法调用语法：引用.方法名(实参);
 *
 * */


//创建学生对象，并访问和修改对象属性
public class FengZhuang {
    public static void main(String[] args) {

/*      // 创建对象
        Student stu_1 = new Student();
        // 修改对象的属性
        stu_1.name = "屈刘杰";
        stu_1.sno = "17100305107";
        stu_1.sex = true;
        stu_1.age = 23;

        // 访问学生信息
        System.out.println("姓名：" + stu_1.name);
        System.out.println("学号：" + stu_1.sno);
        System.out.println("性别：" + stu_1.sex);
        System.out.println("年龄：" + stu_1.age);

        stu_1.age = -23;
        System.out.println("年龄：" + stu_1.age);
        注释原因：私有属性不能直接访问，代码报错。
        */

        // 创建对象
        Student stu_1 = new Student();
        // 读取（修改前）
        System.out.println("修改前访问姓名属性：" + stu_1.getName());
        // 修改
        stu_1.setName("屈刘杰");                   // 修改对象属性，调用封装后的入口方法。语法：引用.方法名(实参)
        // 读取（修改后）
        System.out.println("修改后访问姓名属性：" + stu_1.getName());

        // age属性有安全判断
        // 读取
        System.out.println(stu_1.getAge());
        // 修改
        stu_1.setAge(-20);         // 此处-20实参输入后进行安全判断
        System.out.println(stu_1.getAge());     // 修改的参数不合法，修改失败


    }
}
