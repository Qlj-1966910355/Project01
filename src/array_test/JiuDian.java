package array_test;

public class JiuDian {
    // 二维数组，模拟酒店的所有房间
    private Room[][] rooms;


    // 用构造方法盖楼(初始化)
    public JiuDian() {
        // 动态初始化
        this.rooms = new Room[4][10];           // 3行10列数据，3层，每层10个房间
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (i == 0) {
                    // 一层
                    rooms[i][j] = new Room(100 + (j + 1), "标准间", true);
                } else if (i == 1) {
                    // 二层
                    rooms[i][j] = new Room(200 + (j + 1), "情侣房", true);

                } else if (i == 2) {
                    // 三层
                    rooms[i][j] = new Room(300 + (j + 1), "大床房", true);

                } else if (i == 3) {
                    // 四层
                    rooms[i][j] = new Room(400 + (j + 1), "总统套房", true);

                }
            }
        }

    }

    public void print01() {
        // 打印所有房间状态
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j]);
            }
            System.out.println();
        }
    }

    // 预定房间<前台需要房间编号传递进去>
    public void yuDing(int roomNo){
        Room room = rooms[roomNo / 100 - 1][roomNo % 100 - 1];
        room.setZt(false);
        System.out.println(roomNo + " 已订房！感谢您的预定！！");
    }

    // 退房
    public void tuiFang(int roomNo){
        Room room = rooms[roomNo / 100 - 1][roomNo % 100 - 1];
        room.setZt(true);
        System.out.println(roomNo + " 已退房！欢迎下次光临！！");
    }
}
