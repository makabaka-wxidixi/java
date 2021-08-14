package knowledge;
/*
 * OverLoad（方法的重载）
 * 
 * 1，定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可
 * 			“两同一不同”：同一个类；	相同方法名
 * 						 参数列表不同：参数个数不同，参数类型不同
 * 2，判断方法是否重载：
 * 			跟方法的权限修饰符，返回值类型，形参变量命，方法体都没有关系
 * 3，调用方法时如何确定某一指定方法
 * 			方法名--->参数列表
 */
public class OverLoad {
	public static void main(String[] args) {
		OverLoad p=new OverLoad();
		p.getSum(0, 0);
		p.getSum(1.1, 0);
		p.getSum(0, 2.1);
		int ret=p.getSum("ads", 0);
		System.out.println(ret);
	}
	//如下的四种方法构成了重载
	public void getSum(int i,int j) {
		System.out.println("1");
	}
	public void getSum(double i,int j) {
		System.out.println("2");
	}
	public void getSum(int i,double j) {
		System.out.println("3");
	}
	public int getSum(String i,int j) {
		return 4;
	}
}
