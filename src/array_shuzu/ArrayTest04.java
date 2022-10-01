package array_shuzu;
// 数组中的继承与多态
public class ArrayTest04 {
    public static void main(String[] args) {
        // 创建一个只保存Animal类的子类型元素的数组
        Animal[] array01 = {new Dog(),new Cat()};

        // 此处向上转型，自动类型转换
        array01[0].move();         // 访问数组中第一个元素，并调用该元素的move()方法
        array01[1].move();

        // 访问父类中没有的方法
        Dog d0 = (Dog)array01[0];   // 向下转型
        d0.look();
        // 向下转型标准写法
        if (array01[1] instanceof Cat){
            Cat c = (Cat) array01[1];
            c.eat();
        }
        if(array01[0] instanceof Dog){
            Dog d1 = (Dog)array01[0];
            d1.look();
        }
    }
}


class Cat extends Animal{
    @Override
    public void move() {
        System.out.println("Cat move ……！");
    }
    public void eat(){
        System.out.println("猫在吃猫粮！");
    }
}