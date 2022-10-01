package zhujie;

import java.lang.reflect.Field;

public class Annotation02_Test01 {
    @Annotation02(name = "qlj")
    private String name;
    private String age;

    public String getName() {
        try {
            this.getAnnotation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 反射获取注解内容
     * @return
     */
    public void getAnnotation() throws Exception {
        // 获取当前类文件对象
        Class<?> aClass = Class.forName("zhujie.Annotation02_Test01");
        // 创建当前类对象
        Object obj = aClass.newInstance();
        // 获取所有属性
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            // 判断属性上是否包含@Annotation02注解
            if (field.isAnnotationPresent(Annotation02.class)) {
                // 获取当前field的注释对象
                Annotation02 annotation = field.getAnnotation(Annotation02.class);
                // 获取注释的name值
                String name = annotation.name();
                // 打破私有封装
                field.setAccessible(true);
                // 将注释的值传给属性
                field.set(this, name);
            }else {
                String name = field.getName();
                System.out.println("当前属性" + name + "不包含Annotation02注解！");
            }
        }
    }




    public static void main(String[] args) {
        Annotation02_Test01 test01 = new Annotation02_Test01();
        // 获取属性值
        System.out.println(test01.getName());       // qlj
    }

}
