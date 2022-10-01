package set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 泛型

/**
 * 1、泛型是一种语法机制，只在程序编译起到作用（运行阶段泛型没有！）
 * 2、泛型的优点：
 *      -> 集合中存储的元素类型统一
 *      -> 从集合中取出的类型是泛型指定的类型，不需要进行大量的向下转型
 *    缺点：
 *      -> 集合类型缺乏多样性
 * 3、钻石表达式（自动类型推断机制） jdk7后才可以使用
 *      // List<Animal> myArrayList03 = new ArrayList<>()可以省略<>中的内容
 *
 */


public class Z_FanXing {
    public static void main(String[] args) {
        // 不使用泛型
        // 创建ArrayList集合对象
        List myArrayList01 = new ArrayList();

        // 准备对象
        Cat myCat = new Cat();
        Animal myAnimal = new Animal();
        Dog myDog = new Dog();

        // 将对象添加到集合
        myArrayList01.add(myAnimal);
        myArrayList01.add(myCat);
        myArrayList01.add(myDog);

        // 遍历(取出Cat让它抓老鼠；取出Dog让它睡觉)
        Iterator it01 = myArrayList01.iterator();
        while (it01.hasNext()){
            Object obj01 = it01.next();
            // 向下转型
            if(obj01 instanceof Cat){
                // myCat.eat();
                ((Cat)obj01).eat();
            }else if (obj01 instanceof Dog){
                // myDog.sleep();
                ((Dog)obj01).sleep();
            }
        }

        System.out.println("---------------------------------------");

        // 使用泛型
        // 创建ArrayList集合对象
        List<Animal> myArrayList02 = new ArrayList<Animal>();   // 表示这个集合只能存储Animal类型的数据

        // 将上面的对象存储在myArrayList02中
        myArrayList02.add(myAnimal);
        myArrayList02.add(myCat);
        myArrayList02.add(myDog);

        // 迭代器迭代
        Iterator<Animal> it02 = myArrayList02.iterator();           // 表示迭代器迭代的是Animal类型数据的集合
        while (it02.hasNext()){
            Animal obj02 = it02.next();      // 此时相当于多态（且实际对象是所有集合中继承了Animal的对象）
            // obj02.move();        // 泛型后调用父类的方法可以直接调用（执行3次）

            // 调用子类的方法依然需要向下转型
            if(obj02 instanceof Cat){
                ((Cat)obj02).eat();
            }else if (obj02 instanceof Dog){
                ((Dog)obj02).sleep();
            }else obj02.move();

        }


        // 钻石表达式        // jdk7后才可以使用
        List<Animal> myArrayList03 = new ArrayList<>();     // new ArrayList<>()可以省略<>中的内容

        myArrayList03.add(new Animal());            // 只能存放Animal类型对象
    }
}




class Animal{
    public void move(){
        System.out.println("myAnimal在移动！");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("myCat抓老鼠！");
    }
}
class Dog extends Animal{
    public  void sleep(){
        System.out.println("myDog喜欢睡觉！");
    }
}
