package object01;

import java.util.Objects;

// 使用equals()实现需求
// 需求：当用户名与住址都相同时表示两个对象相同

public class EqualsTest_02 {
    public static void main(String[] args) {
        User u1 = new User("qlj", new Address("蒲城", "上王", "715518"));
        User u2 = new User("qlj", new Address("蒲城", "上王", "715518"));

        System.out.println(u1.equals(u2));
    }
}

// 用户类
class User {
    String name;          // 姓名
    Address address;      // 住址

    // 无参构造方法
    public User() {
    }

    // 有参构造方法
    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // 重写equals()方法
//    public boolean equals(Object o) {
//        if (o == null || !(o instanceof User)) return false;
//        if (this == o) return true;
//        User o1 = (User) o;
//        if (this.name.equals(o1.name) && this.address.equals(o1.address)) {
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(address, user.address);
    }
}

// 住址类
class Address {
    String city;             // 城市
    String street;           // 街道
    String zipcode;          // 邮编

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    // 重写equals()方法
//    public boolean equals(Object o) {
//        if (o == null || !(o instanceof User)) return false;
//        if (this == o) return true;
//        Address o2 = (Address) o;
//        if (this.city.equals(o2.city)
//                && this.street.equals(o2.street)
//                && this.zipcode.equals(o2.zipcode)) {
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipcode, address.zipcode);
    }

}

