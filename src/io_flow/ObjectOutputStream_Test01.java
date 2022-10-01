package io_flow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * ObjectInputStream与ObjectOutputStream
 * 序列化：
 *      序列化：(Serialize)java对象存储到文件中。将java对象的状态保存下来的过程。
 *      反序列化：(DeSerialize)将硬盘上的数据重新恢复到内存中，恢复成java对象。
 * ObjectInputStream与ObjectOutputStream作用：
 *      ObjectInputStream <反序列化>，将硬盘的数据(java对象)恢复到内存中
 *      ObjectOutputStream <序列化>，将内存中的数据(java对象)保存在硬盘中
 *
 * 注意：
 *      1、若被序列化对象的类没有实现Serializable接口，则会报错。
 *         java.io.NotSerializableException: io_flow.Student   <不支持序列化>
 *         < 参与序列化的对象必须实现Serializable接口 >
 *      2、Serializable接口是一个标志性接口（没有任何属性与方法）
 *        源码：
 *              public interface Serializable {
 *              }
 *        作用：
 *              起到一个标识的作用，JVM看到这个类实现这个接口后，会对该类自动生成一个序列号版本号
 *
 *
 *  * java语言怎样区分类的
 *      1、通过类名对比，不同类名，类肯定不同
 *      2、如果类名一样，怎样区分类?
 *          <序列化版本号>不同，表示不同类
 *      eg：
 *          十年前：写了一个Student类（实现了Serializable接口，生成一个序列版本号）
 *          十年后：版本需要升级，必须改动Student类，改变了的Student类，此时重新编译重新生成了一个序列版本号。
 *              <   两个序列版本号都是通过实现Serializable接口自动生成的序列版本号，而且编译生成的版本号不同，
 *              则在反序列化时，运行报错，失败，java将Student类前后当作不同的类，反序列化使用类时必然失败>
 *
 * 序列化版本号
 *      同名，不同序列化版本号，代表不同的类。
 *      只有同名且相同序列版本号，才代表同一个类。
 *
 *      自动生成序列化版本号的缺陷：
 *          自动生成序列化版本号，修改/更新类时，编译后会重新生成一个序列化版本号，这个版本号与修改前的序列化版本号不同，
 *          java虚拟机将修改前后看做不同的类。
 *          所以自动生成序列化版本号不能修改类代码
 *
 *      <故：在序列化时，一般给定一个固定不变的序列版本号，不自动生成版本号></>
 *      eg:
 *          ArrayList类中定义的固定序列化版本号
 *              private static final long serialVersionUID = 8683452581122892189L
 *          String类中定义的固定序列化版本号
 *              private static final long serialVersionUID = -6849794470754667710L;
 *
 * 小知识：
 *      IDEA生成序列化版本号
 *          settings -> Editor -> Inspections -> 搜索Serializable
 *          ->勾选"Serializable class without serialVersionUID"
 *          在实现了Serializable的"类名"上 alt+enter。
 *
 */

public class ObjectOutputStream_Test01 {
    public static void main(String[] args) {
        Student stu = new Student("qlj",24);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("students"));
            oos.writeObject(stu);


            // 刷新
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

class Student implements Serializable{
    private static final long serialVersionUID = -4619174010033009994L;
    private String name;
    private int age;
//    private boolean gender;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
