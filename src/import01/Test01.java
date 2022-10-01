package import01;

import java.util.Date;

/**
 * 关于java语言中的包机制：
 * 1、包又称为package，java中引入package主要是为了方便程序的管理。
 * 不同功能的类被分门别类到不同的软件包中，查找方便，容易维护。
 * <p>
 * 2、怎样定义package？
 * - 在java源程序的第一行编写package语句。
 * - package只能编写一个语句。
 * 语法结构：
 * package 包名;
 * <p>
 * 3、包名命名规范。
 * 公司域名倒序 + 项目名 + 模块名 + 功能名
 * eg：org.apache.tocat.core;
 * com.bjpowernode.oa.user.service;
 * <p>
 * 4、包名要求全部小写，包名也是标识符，必须遵守命名规范。
 * <p>
 * 5、一个包对应一个目录
 * eg：org.apache.tocat.core;        // 四个目录
 * <p>
 * 6、使用包机制在终端内怎样编译？怎样运行？
 * 包的机制实际创建了多个树形目录。在编译和运行时遵循文件具体地址位置编译。（注意在相对地址下运行）
 * 即，在终端内运行步骤：
 * - 编译：javac java原文件路径（生成.class文件）
 * - 创建目录：手动创建目录，将生成的.class文件放在指定包目录下
 * - 运行：java 包目录.文件名
 * <p>
 * 7、不导入包时，调用其他.class文件需要注意文件是否与当前.class文件在同一文件目录下。
 * 在同一个包目录时，直接调用该类
 * 不在同一包目录时，需要将包目录地址写在类文件前做引用。
 * <p>
 * 8、import关键字使用
 * 语法：
 * import 包名.文件名     // 导入指定的.class文件
 * import 包名.*         // 导入指定包的所有类文件
 * <p>
 * 9、import编写在package语句之下，class语句之上。
 * <p>
 * 10、String与System类为什么不需要进行导入包就可以直接调用？
 * // java.lang.* 不需要手动导入，系统自动导入
 * // lang:language语言包，是java核心类，不需要手动导入。
 */
public class Test01 {
    public static void main(String[] args) {
        Date i = new Date();

    }
}
