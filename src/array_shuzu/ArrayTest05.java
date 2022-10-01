package array_shuzu;

// ********************** 数组扩容 *************************
// 定义后的数组不能修改其容量，怎样对其扩充容量
// 方法：新建一个大容量数组，将小容量数组中的元素拷贝到大数组中。（效率较低，尽量减少扩容操作）
public class ArrayTest05 {
    public static void main(String[] args) {
        // 数组间怎样拷贝？
        // 使用方法：System.arraycopy();
        int[] src = {1,2,3};
        int[] dest = new int[10];
        // 进行拷贝
        System.arraycopy(src,0,dest,3,2);
        /**
         * 方法输入参数解析：
         *      参数1：原数组。            <原数组名src></>
         *      参数2：元数组开始位置。     <从src数组的第0位开始></>
         *      参数3：目标数组。           <目标数组名dest></>
         *      参数4：目标数组开始位置。    <从目标数组的第3位开始填充></>
         *      参数5：拷贝个数。            <总共拷贝2个元素></>
         */

        // 遍历目标数组
        for (int i = 0; i < dest.length; i++) {
            int a = dest[i];
            System.out.println("遍历数组dest->" + a);
        }
    }
}
