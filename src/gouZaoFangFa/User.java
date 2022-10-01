package gouZaoFangFa;

// 用户类


public class User {
    // 私有属性
    private String name;

// 当类中没有构造方法，系统默认构建一个下面注释掉的构造方法（隐式无参）。

    /**
     * pubilc User(){
     *     方法体;
     * }
     */

// 构造不同形式的构造函数（重构）
    public User() {
        System.out.println("我是无参数构造方法！");
    }
    public User(int i){
        System.out.println("带有int类型的构造方法！");
    }
    public User(String j){
        System.out.println("带有String类型的构造方法！");
    }
    public User(int i,String j){
        System.out.println("带有int、String类型的构造方法！");
    }

// 私有属性封装入口
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
