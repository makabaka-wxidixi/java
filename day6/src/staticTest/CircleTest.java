package staticTest;

public class CircleTest {
	public static void main(String[] args) {
		Circle c1=new Circle();
		Circle c2=new Circle();
		Circle c3=new Circle(4.5);
		System.out.println(c1.getId());
		System.out.println(c2.getId());
		
		System.out.println(Circle.getTotal());
	}
}

class Circle{
	private double radius;
	private int id;//圆的编号
	
	private static int init=1001;//
	private static int total;//圆的个数
	
	//构造器
	public Circle() {
		id=init++;
		total++;
	}
	public Circle(double radius) {
		this();
		this.radius=radius;
	}
	//方法
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public int getId() {
		return id;
	}
	public static int getTotal() {
		return total;
	}
	
}
