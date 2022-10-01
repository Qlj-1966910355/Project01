package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 反编译一个类的构造方法
 */
public class Constructor01_Test01 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();

        Class myClass = null;
        try {
            // 获取类文件
            myClass = Class.forName("java.lang.String");
            //
            s.append(Modifier.toString(myClass.getModifiers()));
            if(myClass.getModifiers() == 0){
                s.append("class ");
            }else{
                s.append(" class ");
            }

            s.append(myClass.getSimpleName());
            s.append("{\n");
//            System.out.println(s);

            // 拼接构造方法
            Constructor[] c = myClass.getDeclaredConstructors();
            for (Constructor con:c
                 ) {
                // public VipUser(int no, String name);
                s.append("  ");
                // 修饰符
                s.append(Modifier.toString(con.getModifiers()));
                if(con.getModifiers() != 0){
                    s.append(" ");
                }

                // 方法名(使用类名即可)
                s.append(myClass.getSimpleName() + "(");

                // 参数类型列表
                // 先获取参数类型对象
                Class[] cs = con.getParameterTypes();
                for (Class csType:cs
                     ) {
                    s.append(csType.getSimpleName());
                    s.append(",");
                }
                if(cs.length>0){
                    s.deleteCharAt(s.length()-1);
                }

                s.append("){}\n");

            }
            s.append("}");
            System.out.println(s);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}


class VipUser{
    int no;
    String name;
    String password;
    boolean sex;

    public VipUser() {
    }

    public VipUser(int no) {
        this.no = no;
    }

    public VipUser(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public VipUser(int no, String name, String password, boolean sex) {
        this.no = no;
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                '}';
    }
}
