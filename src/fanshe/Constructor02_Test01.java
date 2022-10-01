package fanshe;

import java.lang.reflect.Constructor;

/**
 * 反射机制调用构造方法
 */
public class Constructor02_Test01 {
    public static void main(String[] args) {
        // 不使用反射机制用构造方法创建对象
        VipUser v1 = new VipUser();
        VipUser v2 = new VipUser(111,"qlj");

        // 使用反射机制创建对象
        try {
            Class c = Class.forName("fanshe.VipUser");
            // 调用无参数构造方法
            Object obj = c.newInstance();

            // 调用有参构造方法
            // 第一步：首先获取到有参的构造方法
            Constructor con = c.getDeclaredConstructor(int.class, String.class, String.class, boolean.class);
            // 第二步：调用构造方法new对象
            VipUser objNew = (VipUser) con.newInstance(111,"qlj","111111",true);

            // 获取无参构造方法
            Object objNew02 = c.getDeclaredConstructor().newInstance();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
