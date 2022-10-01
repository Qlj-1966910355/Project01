package set;

import java.util.*;

// TreeMap中元素自定义对象比较器
public class TreeMap_Set02 {
    public static void main(String[] args) {
        /**
         *
         */
        // 创建TreeMap集合（必须给对象添加比较器对象）
        TreeMap<Teacher,String> myTeacher = new TreeMap<>(new teacherComparator());
        // 创建Teacher对象
        Teacher teacher01 = new Teacher();
        Teacher teacher02 = new Teacher(23);
        Teacher teacher03 = new Teacher(24);


        // 对集合添加元素
        myTeacher.put(teacher01,"");
        myTeacher.put(teacher02,"数学");
        myTeacher.put(teacher03,"语文");

        // 将Map类型转换为set类型
        Set<Map.Entry<Teacher,String>> myset = myTeacher.entrySet();
        // 遍历
        Iterator<Map.Entry<Teacher,String>> it01 = myset.iterator();
        while (it01.hasNext()){
            Map.Entry<Teacher,String> myentry = it01.next();
            Teacher mykey = myentry.getKey();
            String myvalue = myentry.getValue();
            System.out.println(mykey + ":" + myvalue);
        }
        /**
         * 创建TreeMap集合时，采用无参构造时，出现下列错误信息
         * 报错信息：Exception in thread "main" java.lang.ClassCastException: set.Teacher cannot be cast to java.lang.Comparable
         * 原因：自定义类作为TreeMap集合的key值不会进行排序输出，所以在put()时就会报错。此时需要对key写一个比较器。
         *
         */


    }
}

// User类
class Teacher{
    String name;
    int age;

    public Teacher(){}
    public Teacher(int age){
        this.age = age;
    }

    @Override // 重写toString方法
    public String toString() {
        return "老师{" +
                "age=" + age +
                '}';
    }
}

// 比较器
// 注意：比较器底层是通过对象的某个int属性进行比较的
class teacherComparator implements Comparator<Teacher>{     // 创建的比较器实现Comparator接口

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.age - o2.age;
    }
}



