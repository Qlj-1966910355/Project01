package array_test;

import java.util.Objects;

public class Room {
    // 房间编号<101、102、103、104；201、202、203、204；301、302、303、304>
    private int no;

    // 房间类型<标准间、情侣房、大床房、总统套房>
    private String type;

    // 房间状态<空闲true、占用false>
    private boolean zt;

// 构造方法
    public Room() {
    }

    public Room(int no, String type, boolean zt) {
        this.no = no;
        this.type = type;
        this.zt = zt;
    }

    // set\get方法
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isZt() {
        return zt;
    }

    public void setZt(boolean zt) {
        this.zt = zt;
    }

    @Override
    public String toString() {
        return "[" + no + "," + type + "," + (zt ? "空闲":"占用") + "] ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return no == room.no &&
                zt == room.zt &&
                Objects.equals(type, room.type);
    }
}
