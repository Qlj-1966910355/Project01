package fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 重点：反射机制调用方法
 * 重点重点重点重点重点重点重点重点重点重点：
 *      调用方法：Object invoke(Object obj, Object... args)      // 参数obj：类对象(实例方法需要对象调用)；args：实参列表
 *
 */
public class Method02_Test01 {
    public static void main(String[] args) {
        //不使用反射机制调用方法
        UserService user01 = new UserService();
        boolean bl = user01.login("admin",123456);
        System.out.println(bl?"登录成功":"登录失败");

        // 反射机制调用方法
        try {

            Class myClass = Class.forName("fanshe.UserService");
            // 创建类对象（实例方法必须要类对象调用）
            Object obj = myClass.newInstance();
            // 获取方法对象
            Method m = myClass.getDeclaredMethod("login", String.class, int.class);
            // 调用方法
            Object returnValue = m.invoke(obj,"admin",123456);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
