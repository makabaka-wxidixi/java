package exercises;

public class Person {
	//属性
	String name;
	int age;
	/**
	 * sex==1, male;
	 * sex==0, famale;
	 */
	int sex;
	
	public void study() {
		System.out.println("studying");
	}
	
	public void showAge() {
		System.out.println("age:"+age);
	}
	
	public int addAge(int i) {
		age+=i;
		return age;
	}
}
