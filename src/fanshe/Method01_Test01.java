package fanshe;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Method方法
 * 1、首先必须获取对应类文件
 * 2、反射机制Method方法：
 *      -> Method[] getDeclaredMethods()            // 获取对应类的所有Method方法对象。(包括私有)
 *      -> String getName()                         // 获取方法名
 *      -> Class<?> getReturnType()                 // 获取返回值类型
 *      -> int getModifiers()                       // 获取属性的修饰符(返回的是int类型，int数据代表着修饰符。)
 *      -> static String toString(int mod)          // 将getModifiers()方法返回的int类型转换为String类型的修饰符字符串
 *      -> Class<?>[] getParameterTypes()           // 获取方法参数类型列表（只获取类型，返回一个Class[]类型数组）
 *      -> String getSimpleName()                   // 获取参数类型名
 *
 */
public class Method01_Test01 {
    public static void main(String[] args) throws NoSuchMethodException {
        try {
            // 获取类文件
            Class myClass = Class.forName("fanshe.UserService");

            // 获取所有Method方法
//            Method[] mtd = myClass.getMethods();     // 与Field一样，受权限修饰符限制
            Method[] mtd = myClass.getDeclaredMethods();
//            myClass.getMethod("logout");
//            myClass.getDeclaredMethod("logout");
            System.out.println("获取到的方法个数：" + mtd.length);

            // 遍历Method（包括私有）
            for (Method m:mtd
                 ) {
                // 获取方法名
                System.out.println("方法名：" + m.getName());

                // 获取返回值类型
                System.out.println("返回值类型：" + m.getReturnType());

                // 返回修饰符
                System.out.println("修饰符：" + Modifier.toString(m.getModifiers()));

                // 方法参数类型列表(参数列表与Field类似，也可能有多个)
                Class[] c = m.getParameterTypes();
                for (Class cs:c
                     ) {
                    // 获取参数类型名
                    System.out.println(cs.getSimpleName());
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

// 用户登录方法
class UserService{
    /**
     *
     * @param name 用户名
     * @param password 密码
     * @return true表示登陆成功；false表示登录失败
     */
    public boolean login(String name ,int password ){
        if("admin".equals(name) && 123456 == password){
            return true;
        }
        return false;
    }

    public void logout(){
        System.out.println("系统已经安全退出");
    }


}
