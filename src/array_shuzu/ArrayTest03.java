package array_shuzu;

public class ArrayTest03 {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] array01 = {a1,a2};

        // 对array01数组进行遍历
        for (int i = 0; i < array01.length; i++) {
            Animal a = array01[i];
            a.move();
            // 代码合并
            // array01[i].move();
        }

        // 动态初始化数组
        Animal[] array02 = new Animal[2];
        array02[0] = new Animal();              // 对Animal[]类型的数组第一个元素进行修改操作/初始化操作
        array02[1] = new Animal();
        // array02[1] = new Product();          // Animal[]类型的数组只能存放Animal类型的元素
        array02[1] = new Dog();                 // Dog类继承了Animal类，可以在Animal[]类型的数组内存放子类型的元素。

        array02[1].move();                      // 直接调用子类中的move()方法

    }
}

class Animal{
    public void move(){
        System.out.println("Animal move ……！");
    }
}

class Product{

}

class Dog extends Animal{
    @Override
    public void move() {
        System.out.println("Dog move ……！");
    }

    public void look(){
        System.out.println("狗在看电视！");
    }
}
