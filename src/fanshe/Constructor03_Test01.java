package fanshe;

/**
 * 给定一个类，获取类的父类，及已经实现了的接口
 */
public class Constructor03_Test01 {
    public static void main(String[] args) {

        try {
            // 获取class类
            Class cls = Class.forName("java.lang.String");

            // 获取String父类
            Class superClass = cls.getSuperclass();
            System.out.println(superClass.getName());
            System.out.println("----------------------");
            // 获取所有实现的接口
            Class[] interfaces = cls.getInterfaces();
            for (Class in:interfaces
                 ) {
                System.out.println(in.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
