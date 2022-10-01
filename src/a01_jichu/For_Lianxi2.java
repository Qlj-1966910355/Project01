package a01_jichu;
// 需求：输出1~10000以内的素数;
// 每8个数换行;

public class For_Lianxi2{
	public static void main(String[] args){
		int x = 0;
		
		for(int i=2;i<=10000;i++){
			boolean k = true;
			
			for(int j =2;j<i;j++){
				
				if(i%j == 0){
					k = false;
					break;
				}
			}
			if(k){
				// 格式化输出（制表位对齐）
				if(i<10){
					System.out.print(i + "       ");
				}
				else if(i<100){
					System.out.print(i + "      ");
				}
				else if(i<1000){
					System.out.print(i + "     ");
				}
				else{
					System.out.print(i + "    ");
				}
				x++;
				// 每8个数字换行
				if(x%8 == 0){
					System.out.println("");	
				}
			}
		}
	}
}

