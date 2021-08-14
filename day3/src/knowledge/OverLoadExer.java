package knowledge;
/**
 * 
 * @author liu
 * @time 21/8/14
 */
 
//1.编写程序，定义三个重载方法并调用。方法名为mOL。
//	三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行
//	平方运算并输出结果，相乘并输出结果,输出字符串信息。在主类的main ()
//	方法中分别用参数区别调用三个方法。
//	2.定义三个重载方法max(),
//	第一个方法求两个int值中的最大值,第二个方法求两个double值中的最大值,第
//	三个方法求三个double值中的最大值,并分别调用三个方法。

public class OverLoadExer {
	public static void main(String[] args) {
		OverLoadExer p=new OverLoadExer();
		p.mOL(4);
		p.mOL(3, 4);
		p.mOL("yasuo");
		
		int a=p.max(4, 6);
		System.out.println(a);
		double b=p.max(1.2, 3.4);
		System.out.println(b);
		double c=p.max(5.6, 2.3, 8.9);
		System.out.println(c);
	}
	public void mOL(int n) {
		System.out.println("平方为："+n*n);
	}
	public void mOL(int n,int m) {
		System.out.println("积为："+n*m);
	}
	public void mOL(String s) {
		System.out.println(s);
	}
	
	public int max(int n,int m) {
		return n>m?n:m;
	}
	public double max(double n,double m) {
		return n>m?n:m;
	}
	public double max(double i,double j,double k) {
		return i>(j>k?j:k)?i:(j>k?j:k);
	}
}
