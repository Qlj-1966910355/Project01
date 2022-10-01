package io_flow;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DateOutputStream
 * 数据专属流
 *      这个流可以将数据连同数据类型一并写入文件
 * 注：这个文本使用记事本打不开，不是普通文本
 */
public class Flow08_Test01 {
    public static void main(String[] args) {
        DataOutputStream dataOut = null;
        try {
            // 创建数据专属流
            dataOut = new DataOutputStream(new FileOutputStream("aaaa"));
            // 写数据
            byte b = 98;
            int i = 40;
            short s = 22;
            long l = 1000L;
            float f = 0.23F;
            double d = 3.14D;
            boolean bl = true;
            char c = 'a';
            dataOut.writeByte(b);
            dataOut.writeInt(i);
            dataOut.writeShort(s);
            dataOut.writeLong(l);
            dataOut.writeFloat(f);
            dataOut.writeDouble(d);
            dataOut.writeBoolean(bl);
            dataOut.writeChar(c);


            // 刷新
            dataOut.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dataOut != null){
                try {
                    dataOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
