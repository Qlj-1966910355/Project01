package string_GongJu;

/**
 * String类
 *  1、字符串存储位置：
 *      在jdk中双引号引用的字符串是直接存储在方法区内存中的“字符串常量池”。
 *  2、声明并初始化
 *      1> String 变量名 = " 字符串 ";              <实际创建一个对象></>
 *      2> String 变量名 = new String("字符串");      <实际创建两个对象></>
 *          当使用1>初始化：字符串直接存储在方法区的常量池中，常量池的字符串地址直接给String类型的局部变量。
 *          当使用2>初始化：字符串依然保存在方法区的常量池中，但是常量池中的字符串地址没有直接给局部变量，而是在堆内存中创建了一个对象，
 *                        字符串地址在对象中保存，对象的地址在局部变量中保存。（变量是实例变量时，声明的实例变量在堆内存中存储。）
 *  3、为什么String类型是引用类型，但在比较字符串相等时可以使用"=="？（一般还是使用equals()）
 *      原因：String类型字符串直接保存在常量池中，使用1>方法初始化时，在堆内存中不创建对象，局部变量直接引用常量池内字符串地址，
 *           所以，不同的局部变量引用相同字符串时，内部存储地址不变（与常用基本数据类型比较时原理相同）
 *          eg:String var_1 = "abc";
 *             String var_2 = "abc";
 *             if(var_1 == var_2){
 *                  true;           // 输出true
 *             }false;
 *  4、********************* 注意 **********************
 *      String var_1 = new String("abc");
 *      字符串“abc”是一个对象，可以当做引用使用。（常量池中是一个字符串对象）
 *
 *  5、String构造方法
 *      -> 数字构造字符串
 *         byte[] byte01 = {1,2,3,4,5};
 *         String s = new String(byte01);         // 输出：“12345”
 *         String s = new String(byte01,2,2);     // 从第三个元素开始，步长是2；输出：“34”
 *
 *      -> 字符构造字符串
 *         char[] chr01 = {'a','b','c','d','e'};
 *         String s = new String(chr01);         // 输出：“abcde”
 *         String s = new String(chr01,2,2);     // 从第三个元素开始，步长是2；输出：“cd”
 *
 *  6、String类常用方法

 */
public class String_test01 {
    public static void main(String[] args) {
        String var_01 = new String("abcdefg");
        String var_02 = "higklmn";
        // chaAt()          // 返回指定索引处的字符
        System.out.println("1、字符串var_01索引1处的字符：" + var_01.charAt(1) + "\n  或：" + "abcdef".charAt(1));

        // contains()           // 判断字符串是否包含某字符串
        System.out.println("2、字符串var_01中是否包含“cde”字符串：" + var_01.contains("cde"));

        // endsWith()           // 判断字符串是否以某字符串结尾
        System.out.println("3、字符串是否以'f'结尾：" + var_01.endsWith("f"));

        // equals()         // 判断两个字符串是否相等
        System.out.println("4、判断两个字符串是否相等：" + "adadasa".equals("adsd"));

        // getBytes()           //将字符串对象转换为字节数组
        System.out.println("5、字符串转换为字节数组");
        byte[] bytes = "ada".getBytes();                     // 注意：byte类型
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("  遍历输出bytes["+ i +"]：" + bytes[i]);
        }

        // indexOf()            // 判断某个字符串在当前字符串中第一次出现处的索引
        System.out.println("6、判断字符串中指定字符串的首次出现索引位置：" + "fcasfjavaawfjavaqwd".indexOf("java"));

        // isEmpty()            // 判断某个字符串是否为空。（注意：不是null。也可以用"字符串".length() =0）
        System.out.println("7、判断字符串是否为空：\n" + "   -> 为空时：" + "".isEmpty() + "\n   -> 不为空时：" + "a".isEmpty());

        // length()            // 字符串长度             注：数组的是属性length，字符串中的是方法length();
        System.out.println("8、字符串长度：" + "adas".length());

        // lastIndexOf()判断某子字符串在字符串中最后一次出现的首字符索引
        System.out.println("9、判断字符串中指定字符串的最后一次出现索引位置：" + "ajavawajavac".lastIndexOf("java"));

        // replace()/replaceAll()            // 替换
                // replaceAll()     替换字符串所有匹配给定的正则表达式的子字符串
        System.out.println("10、replace替换字符串：" + "http://www.baidu.com".replace("http","https"));

        // split()          // 拆分字符串成一个字符串类型数组
        String[] str01 = "1=2=3=4".split("=");
        System.out.println("11、拆分字符串成一个字符串数组：" + str01[0]);

        // startsWith()         // 判断字符串是否以某子字符串开始
        System.out.println("12、判断字符串是否以某子字符串开始：" + "javaawdawdawd".startsWith("java"));

        // substring()          // 截取字符串
        System.out.println("13、截取字符串：" + "quliujie".substring(2,5));    // 参数5不是步长，是结束索引

        // toCharArray()            // 字符串转换成char[]类型数组
        char[] chr_01 = "沙钢集团！".toCharArray();
        System.out.println("14、字符串转换成char[]类型：" + chr_01[0]);

        // toLowerCase()            // 字符串转化为小写
        System.out.println("15、字符串转化为小写：" + "ABCDEFG".toLowerCase());

        // toUpperCase()            // 字符串转化为大写
        System.out.println("16、字符串转化为小写：" + "abc".toUpperCase());

        // trim()           // 去除字符串前后空白
        System.out.println("17、去除字符串前后空白：" + " my name is qlj！    ".trim());

        // valueOf()            // 将非字符串转换为字符串      注：String类中唯一的静态方法。不需要创建对象就可以使用
        System.out.println("18、将非字符串转换为字符串：" + String.valueOf(1.23));

        // append()/"+"         // 字符串拼接
        System.out.println("19、字符串连接：\n" + "    使用\"+\"时-> abc" + "de");
        // append()方法具体看stringBuffer类

        // compareTo()          // 按(ASCII)字典顺序比较两个字符串
        System.out.println("20、字符串比较：" +    "04010".compareTo("1402"));




    }




}
