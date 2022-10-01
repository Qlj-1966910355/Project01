package fanshe;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 利用反射机制反编译方法
 */
public class Method01_Test02 {
    public static void main(String[] args) {
        // 创建StringBuilder对象（拼接字符串）
        StringBuilder sb = new StringBuilder();
        // 获取class文件
        try {
            Class myClass = Class.forName("java.lang.String");
            // 获取所有Method方法对象
            Method[] ms = myClass.getDeclaredMethods();

            for (Method m:ms
                 ) {
                // 追加修饰符
                if(m.getModifiers() == 0){
                    sb.append(Modifier.toString(m.getModifiers()));
                }else{
                    sb.append(Modifier.toString(m.getModifiers()) + " ");
                }


                // 返回类型
                sb.append(m.getReturnType().getSimpleName() + " ");

                // 方法名
                sb.append(m.getName() + "(");
                
                // 参数类型列表
                // 先获取参数类型对象
                Class[] c = m.getParameterTypes();
                for (int i = 0; i < c.length; i++) {
                    sb.append(c[i].getSimpleName());

                    if(i != c.length-1){
                        sb.append(",");
                    }
                }
                sb.append("){}\n");
            }

            System.out.println(sb);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
