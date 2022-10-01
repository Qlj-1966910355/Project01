package fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 用反射机制反编译.class文件类属性（不能获取到属性的默认值）
 */

public class Field01_Test02 {
    public static void main(String[] args) {
        // 创建StringBuilder对象（拼接字符串）
        StringBuilder sbd = new StringBuilder();

        Class myClass = null;
        try {
            // 获取class文件
//            myClass = Class.forName("fanshe.MyCat");
            myClass = Class.forName("java.lang.String");

            // 创建Field[]类
            Field[] fields = myClass.getDeclaredFields();

            // 遍历获取属性并追加进字符串内
            sbd.append("class MyCat{\n");
            for (Field f:fields
                 ) {
                sbd.append("    ");

                // 获取修饰符
                if(f.getModifiers() == 0){
                    sbd.append(Modifier.toString(f.getModifiers()));
                }else{
                    sbd.append(Modifier.toString(f.getModifiers()) + " ");
                }

                // 获取属性数据类型
                sbd.append(f.getType().getSimpleName() + " ");

                // 获取属性名
                sbd.append(f.getName());
                sbd.append(";\n");

            }
            sbd.append("}");
            System.out.println(sbd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
