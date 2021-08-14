package knowledge;

/*
 * 1.定义一个类CircleTest，在类中定义一个方法printAreas(),
 * 2.该方法的定义如下:public void printAreas(Circle c, int time)在printAreas方
 * 法中打印输出1到time之间的每个整数半径值，以及对应的面积。例如，time为5，则输
 * 出半径1，2,3，4，5,以及对应的圆面积。
 * 3.在main方法中调用printAreas()方法，调用完毕后输出当前半径值。
 */
class Circle {//圆类
	double radius=1.0;  
	public double CircleArea(){
		return Math.PI*radius*radius;
	}
}

public class CircleTest {
	
	public static void main(String[] args) {
		CircleTest test=new CircleTest();
		
		Circle c=new Circle();
		
		test.printAreas(c, 4);
		
		System.out.println("修改之后的半径："+c.radius);
	}
	
	public void printAreas(Circle c, int time) {
		System.out.println("dadius"+"\t\t"+"area");
		
		for(int i=1;i<=time;i++) {
			c.radius=i;//设置半径
			double ret=c.CircleArea();
			System.out.println(c.radius+"\t\t"+ret);
		}
	}
}


