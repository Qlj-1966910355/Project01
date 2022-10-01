package set;

// 自定义泛型
public class Z_FanXing02 {
    public static void main(String[] args) {
        // 创建Some对象,并指定泛型类型
        Some<String> mySome = new Some<>();
        // 调用doSome()方法只能是String类型的实际参数
        // mySome.doSome(111);          // 编译报错，方法实参为String类型

        mySome.doSome("111");

        // 未指定泛型（参数类型为Object类型）
        Some my = new Some();
        my.doSome(111);
    }
}

// 定义Some类
// 对Some类添加自定义泛型
class Some<AAAAA>{
    // 实际是将数据类型参数化（让调用者去指定实参的数据类型）
    // 调用者不指定类型时，默认为Object类型
    public void doSome(AAAAA obj){
        System.out.println("调用doSome()方法!");
    }
}
