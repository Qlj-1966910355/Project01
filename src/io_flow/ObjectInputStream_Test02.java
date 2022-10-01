package io_flow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;

/**
 * 多个对象反序列化
 */
public class ObjectInputStream_Test02 {
    public static void main(String[] args) {
        // 创建反序列化变量
        ObjectInputStream ois = null;
        try {
            // 创建反序列化对象
            ois = new ObjectInputStream(new FileInputStream("user"));
            // 反序列化
            // 返回一个List集合类型
            List<User> list = (List<User>) ois.readObject();

            // 遍历集合
            Iterator<User> it = list.iterator();
            while (it.hasNext()){
                System.out.println("-> " + it.next());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
