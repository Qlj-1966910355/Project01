package a01_jichu;
// 需求：使用for循环
// 绘制乘法口诀表


public class For_Lianxi{
	public static void main(String[] args){
		int result = 0;
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				// i*j为排列，当i与j取1~9时，全排序：9*9=81组排序
				if(i >= j){
					result = i * j;
					System.out.print(j + "*" + i + "=" + result + "  ");
					// 当结果为个位数时多输出一个空格。（制表位对齐）
					if(result < 10){
						System.out.print(" ");
					}
				}
			}
			System.out.println("");          // 外层循环，i每循环一次进行换行操作（输出格式：j*i）,i在后。
		}
	}
}