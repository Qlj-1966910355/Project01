package array_test;
// 使用一维数组，模拟栈数据结构
/**
 * 需求：
 *  1、这个栈可以存储任何类型的数据（包括引用数据类型）
 *  2、在栈中提供push方法模拟压栈（栈满需要有提示信息）
 *  3、在栈中提供pop方法模拟弹栈（栈空需要有提示信息）
 *  4、编写测试程序，new栈对象，调用push与pop方法模拟压栈与弹栈动作。
 */

public class Zhan_Test01 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();




    }
}

// 栈类
class MyStack{
    // 提供一个数组存储栈中的元素
    private Object[] elements;           // 存放Object类型：栈可以存放Java任何类型的数据

    // 栈帧（永远指向栈顶元素）
    // 每加一个元素，栈帧+1
    // 每减一个元素，栈帧-1
    private int index;
    String i;


    // 无参构造方法，默认初始栈容量为10
    public MyStack(){
        this.elements = new Object[10];
        this.index = -1;
    }


    // push()方法
    // 压栈表示栈中多一个元素
    // 栈满压栈失败
    // 参数及返回值类型自行定义
    public void push(Object obj){
        if (this.index >= this.elements.length - 1){
            System.out.println("压栈失败，栈已满！");
            return;
        }

        this.index++;
        this.elements[index] = obj;
        System.out.println("压栈成功！栈帧指向：" + this.index);
    }



    // pop()方法
    // 弹栈表示栈中少一个元素
    // 栈空，弹栈失败
    // 参数及返回值类型自行定义
    public void pop(){
        if(this.index == -1){
            System.out.println("栈空！");
            return;
        }
        System.out.print("弹栈" + this.elements[index] + "元素成功！！！");
        this.index--;
        System.out.println("目前栈帧指向" + this.index);

    }


    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}