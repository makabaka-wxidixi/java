package cylinderTest;

public class CylinderTest {
	public static void main(String[] args) {
		Cylinder cylinder=new Cylinder();
		cylinder.setHeight(4);
		cylinder.setRadius(2);
		
		
		System.out.println(cylinder.getVolume());
	}
}
