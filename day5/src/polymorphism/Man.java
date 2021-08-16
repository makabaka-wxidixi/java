package polymorphism;

public class Man extends Person{

	boolean isSmoking;
	
	public void earnMoney() {
		System.out.println("男人负责挣钱养家");
	}
	
	public void eat() {
		System.out.println("男人要多吃肉，长肌肉");
	}
	
	public void walk() {
		System.out.println("男人要霸气的走路");
	}
}
