package jiCheng;

// 父亲类
public class Father {
    // 姓氏
    String name;
    // 住址
    String home;
    // 姓名
    private String xingming;
    // 年龄
    private int age;
    // 身高
    private int height;

    // 无参构造函数
    public Father() {
        super();
    }

    // 有参构造函数
    public Father(String name, String home, int age) {
        this.name = name;
        this.home = home;
        this.age = age;
    }

    // 吃（实例方法）
    public String eat() {
        System.out.println("Father喜欢蹲着吃饭！");
        return xingming;
    }

    // 看（实例方法）
    public String look(){
        System.out.println("Father喜欢看手机！");
        return xingming;
    }

    // 睡（静态方法）
    public static void sleep() {
        System.out.println("Father喜欢侧躺睡觉！");
    }

    // 封装获取年龄
    public int getAge() {
        return age;
    }

    // 封装修改年龄
    public void setAge(int age) {
        this.age = age;
    }

    // 封装访问姓名
    public String getXingming() {
        return xingming;
    }

    // 封装修改姓名
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    // 封装访问身高
    public int getHeight() {
        return height;
    }

    // 封装修改身高
    public void setHeight(int height) {
        this.height = height;
    }
}
