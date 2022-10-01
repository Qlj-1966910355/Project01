package a01_jichu;

/*
	条件语句 if 和 switch
*/
public class Grade{
	public static void main(String[] args){
		int sx = 95;
		int yw = 81;
		if(sx >= 60){
			System.out.println("数学及格！");
		}else{
			System.out.println("数学没有及格！");
			}
//------------------------------------------------
		if(yw >= 90){
			System.out.println("语文优秀！");
		}else if(yw >= 80){
			System.out.println("语文良好！");
		}else if(yw >=60){
			System.out.println("语文及格！");
		}else {
			System.out.println("语文不及格！");
			}
		}
	}
/*
输出：
	数学及格！
	语文良好！
*/
//------------------------------------------------------

// 注：switch语句的表达必须是整型与字符型/字符串型;（不能为浮点型）
class Switch_1{
	public static void main(String[] args){
		String var_1 = "屈刘杰";
		switch(var_1){                                  // 必须是整型与字符型/字符串型
			case "许永琪":
				System.out.println("这不是我！");
				break;
			case "屈刘杰":
				System.out.println("恭喜你猜对了！");
				break;
			default:
				System.out.println("以上都不是！");
			}
		}	
	}