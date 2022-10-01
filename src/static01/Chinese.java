package static01;

// “中国人”类
public class Chinese {
    // 身份证（实例变量）
    String id;

    // 姓名（实例变量）
    String name;

    // 国籍（每个中国人的国籍都是“中国”）（实例变量）
    String country;

    // 无参构造方法
    public Chinese() {
        // 默认实例变量
        /**
         this.id = null;
         this.name = null;
         this.country = null;
         */

        // 采用调用有参构造方法进行初始化（必须在方法体首行）
        // this("1","2","3");

    }

    // 有参构造方法
    public Chinese(String id, String name, String country) {
        // 初始化实例变量
        this.id = id;
        this.name = name;
        this.country = country;
    }


}
