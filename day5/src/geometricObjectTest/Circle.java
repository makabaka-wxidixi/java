package geometricObjectTest;


public class Circle extends GeometricObject{
	private double radius;

	public Circle() {
		super();
		radius=1.0;
//		color="white";
//		weight=1.0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius,String color,double weight) {
		super(color,weight);
		this.radius = radius;
	}
	
	

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double findArea() {
		return 3.14*radius*radius;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if (obj instanceof Circle) {
			Circle new_name = (Circle) obj;
			if(new_name.radius==this.radius) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "Cricle [radius="+radius+"]";
	}
	//public boolean 
}
