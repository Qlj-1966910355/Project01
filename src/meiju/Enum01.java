package meiju;
public enum Enum01 {
    RED(1,"红色"), YELLOW(2,"黄色"), BLUE(3,"蓝色"), GREEN(4,"绿色");

    private int num;
    private String color;

    // 无参构造方法
    private Enum01(){       // 必须使用private
        System.out.println("无参构造方法被调用！");
    }

    // 有参构造方法
    Enum01(int num, String color){
        this.num = num;
        this.color = color;
    }

    // 成员方法
    public void doSome(){
        System.out.println("序号：" + num + "；颜色：" +color);
    }
}

class EnumTest{
    public static void main(String[] args) {
        // 访问枚举成员
        Enum01 red = Enum01.RED;
        red.doSome();           // 序号：1；颜色：红色
        Enum01.valueOf("RED");          // RED
        System.out.println(Enum01.valueOf("RED"));

        Enum01[] values = Enum01.values();
        // 遍历枚举对象名称
        for (Enum01 value : values) {
            System.out.println(value);
        }

        Enum01.RED.name();          // RED
        Enum01.BLUE.toString();     // BLUE
        red.ordinal();          // 0

    }
}




