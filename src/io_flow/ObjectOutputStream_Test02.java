package io_flow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 多个对象序列化（将对象存入集合中）
 */
public class ObjectOutputStream_Test02 {
    public static void main(String[] args) {
        // 创建集合对象
        List<User> myList = new ArrayList<>();
        // 添加User对象
        myList.add(new User("qlj","121212"));
        myList.add(new User("zmq","667788"));
        myList.add(new User("wzx","111111"));
        myList.add(new User("xyq","123456"));

        // 创建序列化变量
        ObjectOutputStream oos = null;
        try {
            // 创建序列化对象
            oos = new ObjectOutputStream(new FileOutputStream("user"));

            // 序列化
            oos.writeObject(myList);


            // 刷新
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}



class User implements Serializable{
    private static final long serialVersionUID = 4759505207202105225L;
    // transient关键字
    // 表示游离的，被修饰的属性不参与序列化（反序列化到内存后id值为null）
    private transient String id;
    private String password;

    public User() {
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
