package static01;

public class Test01 {
    public static void main(String[] args) {
        // 创建对象1
        Chinese c1 = new Chinese("a00","许永琪","中国");
        System.out.println(c1.id + "，" + c1.name + "，" + c1.country);

        // 创建对象2
        Chinese c2 = new Chinese("a01","屈刘杰","中国");
        System.out.println(c2.id + "，" + c2.name + "，" + c2.country);

        // 创建对象3
        Chinese c3 = new Chinese("a02","王泽轩","中国");
        System.out.println(c3.id + "，" + c3.name + "，" + c3.country);

    }

}
