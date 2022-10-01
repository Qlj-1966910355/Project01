package io_flow;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DataInputStream
 * DataOutputStream写的数据文件，只能使用DataInputStream去读。并且读的时候需要知道写入的顺序。
 * 读的顺序需要与写的顺序一致才能正常读出数据。
 *
 */
public class Flow09_Test01 {
    public static void main(String[] args) {
        DataInputStream in = null;
        try {

            in = new DataInputStream(new FileInputStream("aaaa"));
            // 读（必须按照插入顺序）
            byte b = in.readByte();
            int i = in.readInt();
            short s = in.readShort();
            long l = in.readLong();
            float f = in.readFloat();
            double d = in.readDouble();
            boolean bl = in.readBoolean();
            char c = in.readChar();

            System.out.println(b);
            System.out.println(i);
            System.out.println(s);
            System.out.println(l);
            System.out.println(f);
            System.out.println(d);
            System.out.println(bl);
            System.out.println(c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
