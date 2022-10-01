package fanshe;

import java.lang.reflect.Field;

/**
 * 通过反射机制访问一个java对象的属性
 *      给属性赋值set
 *      获取属性的值get
 */
public class Field01_Test03 {
    public static void main(String[] args) {
    // 不使用反射机制访问属性
        MyCat cat01 = new MyCat();
        // 访问实例变量
        cat01.age = 10;
        // 访问静态变量
        MyCat.catName = "汤姆";


    // 使用反射机制访问属性
        try {
            // 获取class文件
            Class myClass = Class.forName("fanshe.MyCat");
            // 创建对象（只能使用无参构造方法）
            Object obj = myClass.newInstance();

            // 获取age属性
            Field fd = myClass.getDeclaredField("age");
            // 修改obj对象的属性值
            fd.set(obj,11);

            // 读取属性值
            System.out.println(fd.get(obj));

            /**
             * 上面使用反射机制访问属性，体现了反射机制的灵活性，虽然访问代码量变多了，但是可以再配置文件中灵活修改属性值。
             * 注：不能访问私有属性
             */

            // 如何访问私有属性
            Field genderField = myClass.getDeclaredField("gender");
            // 重点：打破私有封装限制（不安全）
            genderField.setAccessible(true);
            // 修改obj对象属性值
            genderField.set(obj,false);
            // 读取属性值
            System.out.println(genderField.get(obj));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
