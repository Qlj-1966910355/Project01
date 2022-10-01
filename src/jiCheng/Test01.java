package jiCheng;

public class Test01 {
    public static void main(String[] args) {
        // 创建对象1
        /**
         * Son类中没有name和home两个实例变量，通过继承关系将两个实例变量关联过来
         */
        Son p0 = new Son();
        System.out.println("子类p1对象姓名：" + p0.getXingming());
        /**
         * 重点：由于xingming属性是私有属性，但继承到了父类的setXingming()和getXingming()方法
         *      所以使用Son类创建的对象可以进行访问与修改xingming属性。但是，
         *      ******** 访问与修改的属性不是子类中的xingming属性，而是父类中的该属性 ********
         */

        Son p1 = new Son("屈","陕西",23,"屈刘杰");
        System.out.println("子类p1对象姓氏：" + p1.name);
        System.out.println("子类p1对象住址：" + p1.home);

        System.out.println("子类p1对象身高：" + p1.getHeight());
        p1.setHeight(180);
        System.out.println("子类p1对象身高：" + p1.getHeight());
            // 注意height属性为私有属性，之所以能够访问与修改是因为get与get方法并没有被私有化，但此处访问与修改的是父类中的该属性。

        // 调用子类中的eat()方法(被子类重写)
        p1.eat();

        // 调用子类中的sleep()方法（被子类隐藏）
        p1.sleep();

        // 调用父类中的look()方法（子类中无look()方法）
        p1.look();

    }
}
