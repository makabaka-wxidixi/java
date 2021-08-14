package knowledge;


/*
 * 匿名对象的使用
 * 1，理解：创建一个对象，没有显示的赋给一个变量名，就是匿名对象
 * 2，特征：匿名对象只能使用一次
 * 3，使用
 */
public class Anonymous_object {
	public static void main(String[] args){
		
		//有名
		Phone p=new Phone();
		
		p.sendEmail();
		p.playGame();
		System.out.println("-----------------------------");
		//匿名
		//直接new一个新的区域，并且直接调用类中的方法
		new Phone().sendEmail();
		new Phone().playGame();
		System.out.println("-----------------------------");
		new Phone().price=10;//修改参数
		System.out.println(new Phone().price);//0.0，说明是两个独立的区域
		System.out.println("-----------------------------");
		PhoneMall mall=new PhoneMall();
		mall.phoneFunction(new Phone());//new完直接作为形参
		
	}
}

class PhoneMall{
	public void phoneFunction(Phone phone) {
		phone.sendEmail();
		phone.playGame();
	}
}

class Phone{
	double price;
	
	public void sendEmail() {
		System.out.println("发送邮件");
	}
	public void playGame() {
		System.out.println("玩游戏");
	}
	
}
