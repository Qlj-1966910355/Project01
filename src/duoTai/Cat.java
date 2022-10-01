package duoTai;

public class Cat extends DongWu {
    // 重写父类中的move()方法
    public void move(){
        System.out.println("猫在走猫步！");
    }
    public void eat(){
        System.out.println("猫在吃猫粮！");
    }
}
