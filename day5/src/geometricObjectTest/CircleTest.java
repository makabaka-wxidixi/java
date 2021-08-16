package geometricObjectTest;

public class CircleTest {
	public static void main(String[] args) {
		Circle c1=new Circle(3.3);
		Circle c2=new Circle(3.3);
		System.out.println(c1.equals(c2));
		System.out.println(c1.toString());
		System.out.println(c1.getColor().equals(c2.getColor()))	;
	}
}
