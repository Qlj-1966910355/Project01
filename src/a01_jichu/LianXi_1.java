package a01_jichu;
// if语句
/**
	* 判断当前天气：
	* 	当下雨时：
	* 		带雨伞：
	* 			判断性别：
	* 				男：带一把小黑伞
	* 				女：带一把小花伞
	* 	晴天时：
	* 		判断温度：
	* 			30°以上：
	* 				男：戴墨镜
	* 				女：擦防晒 
	* 
	* 要求：天气状况、温度、性别需要用户输入
	* 	天气：1表示下雨，0表示晴天
	* 	性别：1表示男性，0表示女性
	* 
*/


public class LianXi_1{
	public static void main(String[] args){
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		System.out.println("输入当前天气状况\n1：表示下雨；\n0：表示晴天\n请输入：");
		int tq = s.nextInt();          // 输入天气
		
		// 判断天气
		if (tq == 1){
			System.out.println("当前天气为雨天，请您外出带好雨伞");
			System.out.println("请输入您的性别，为您选择合适的雨伞\n1：表示男性；\n0：表示女性\n请输入：");
			int xb = s.nextInt();        // 输入性别
			
			// 判断性别
			if (xb == 1){
				System.out.println("已经为您提供一把黑色的雨伞，请您查收！");
			}else if (xb == 0){
				System.out.println("已经为您提供一把彩色的雨伞，请您查收！");
			}else{
				System.out.println("您输入的性别出错！请重新执行！");
			}
		}else if (tq == 0){
			System.out.println("当前天气为晴天，请您输入当前温度为您推荐出行建议：");
			int wd = s.nextInt();        // 输入温度
			
			// 判断温度
			if (wd > 30){
				System.out.println("当前温度大于30℃，请输入性别为您推荐出行建议\n1：表示男性；\n0：表示女性\n请输入：");
				int xb = s.nextInt();      // 输入性别
				
				// 判断性别
				if (xb == 1){
					System.out.println("当前温度过高，请佩戴墨镜！");
				}else if(xb == 0){
					System.out.println("当前温度过高，请擦防晒霜！");
				}else{
					System.out.println("您输入的性别出错！请重新执行");
				}
			}else{
				System.out.println("当前温度未超过30℃，请您安全出行！");
			}
		}else{
			System.out.println("输入天气出错！请重新执行！");
		}
	}
}