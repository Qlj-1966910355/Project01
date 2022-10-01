package fanshe;

import java.util.ResourceBundle;

/**
 * 资源绑定器
 *  java.util包内提供了一个资源绑定器，便于获取属性配置文件中的内容
 *  注：
 *      --> 这种方式只能获取properties后缀的文件内容
 *      --> 文件必须存储在类路径下
 *      --> 路径不能写后缀properties后缀
 */
public class FS05_Test03 {
    public static void main(String[] args) {
        // 资源绑定器获取配置信息
        ResourceBundle bundle = ResourceBundle.getBundle("fanshe/fanshe3");
        // 通过key获取value
        String value = bundle.getString("className");
        // 打印
        System.out.println(value);
    }

}
