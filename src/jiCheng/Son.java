package jiCheng;

// 儿子类
public class Son extends Father{
    // 姓氏
        // 继承父类
    // 住址
        // 继承父类
    // 姓名
    private String xingming;
    // 年龄
    private int age;

    public Son(){
        super();
    }

    public Son(String name, String home, int age,String xingming){
        this.name = name;
        this.home = home;
        this.age = age;
        this.xingming = xingming;
    }

    // 玩（实例方法）
    public String play(){
        System.out.println("Son我喜欢玩耍！");
        return xingming;
    }


    /**
     * 静态类方法。由于父类是一个静态类方法，此时的sleep()方法不是将父类的sleep()方法重写后的方法，
     *         而是将父类的的sleep()方法进行了”隐藏“。
     * 当调用被隐藏的方法时，调用的版本取决于是从父类中调用还是从子类中调用。
     */
    // 睡（静态方法）
    public static void sleep() {
        System.out.println("Son喜欢平躺睡觉！");
    }


    /**
     * 当一个子类中一个实例方法具有与父类中的一个实例方法相同的签名（指名称、参数个数和类型）和返回值时
     * 则称子类的方法”重写“了父类的方法。
     */
    // 吃（实例方法）
    public String eat() {
        System.out.println("Son喜欢坐着吃饭！");
        return name;
    }

}
