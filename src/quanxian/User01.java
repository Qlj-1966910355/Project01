package quanxian;

public class User01 {
    public int a1;           // 公开的     <公开属性，都可以访问>
    protected int a2;        // 受保护的   <只能在同包或继承该类的子类中直接访问>
    int a3;                  // 缺省的     <只能在同一个包内直接访问>
    private int a4;          // 私有的     <只能在变量所在类直接访问>

}
