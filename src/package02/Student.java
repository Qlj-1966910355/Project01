package package02;

public class Student {
    private String name;          // 私有属性，需要访问该属性，需要在类中编写set()、get()方法。
    private String sno;           // 私有属性
    boolean sex;                  // 私有属性
    private int age;

    // 姓名封装
    public String getName() {       // 自动生成类封装（右键-->generate-->Getter and Setter-->选择属性）
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 学号封装
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    // 年龄封装
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // 判断年龄是否合法
        if(age < 0 || age > 150){
            System.out.println("输入的年龄不合法！");
            return;
        }
        this.age = age;
    }
}


