package gouZaoFangFa;

public class Test02 {

    // 带有static的方法
    public static void method1(){                         // 静态方法
        // 调用doSome
        // 完整方式调用
        Test02.doSome();
        // 省略方式调用（不能省略不写）
        doSome();
        // 调用doOther
        // 完整方式调用
        Test02 t = new Test02();
        t.doOther();
        // 省略方式调用（不能省略不写）
            // 无省略方式

        // 访问i
        // 完整方式调用
        System.out.println("i--> " + t.i);    // 访问
        t.i = 100;                            // 修改（只针对当前对象进行修改）
        System.out.println("i--> " + t.i);    // 修改后再访问
        // 省略方式调用（不能省略不写）
            // 无省略方式

    }
    // 没有static的方法
    public void method2(){                                  // 实例方法
        // 调用doSome
        // 完整方式调用
        Test02.doSome();
        // 省略方式调用（不能省略不写）
        doSome();

        // 调用doOther
        // 完整方式调用
        this.doOther();
        // 省略方式调用（不能省略不写）
        doOther();

        // 访问i
        // 完整方式调用
        System.out.println("i--> " + this.i);         // this在实例方法内使用
        // 省略方式调用（不能省略不写）
        System.out.println("i--> " + i);
    }

    // 主方法
    public static void main(String[] args){
        // 要求在这里编写程序调用method1
        // 完整方式调用
        Test02.method1();
        // 省略方式调用（不能省略不写）
        method1();

        // 要求在这里编写程序调用method2
        // 完整方式调用
        Test02 tt = new Test02();
        tt.method2();
        // 省略方式调用（不能省略不写）
            // 无省略方式
    }

    // 没有static的变量                                       // 实例变量
    int i = 10;

    // 带有static的方法
    public static void doSome(){                             // 静态方法
        System.out.println("do some！");

    }
    // 没有static的方法
    public void doOther() {                                  // 实例方法
        System.out.println("do other!");
    }

}
