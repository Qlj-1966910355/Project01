package a01_jichu;
// 输出1~100以内的素数

public class For_Lianxi1{
	public static void main(String[] args){
		for(int i=1;i<101;i++){
			boolean k = true;            // 内层循环循环完成后k变量会进行重置，重新应用于新的i。
			for(int j =2;j<i;j++){
				if(i%j == 0){              // 
					k = false;
					break;
				}
			}
			if(k){
				System.out.println(i);
			}
		}
	}	
}