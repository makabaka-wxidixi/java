package polymorphism;
/*
 * 多态性的使用
 */
public class AnimalTest {
	public static void main(String[] args) {
		
		AnimalTest test=new AnimalTest();
		test.func(new Dog());
		
		test.func(new Cat());
	}
	//参数是父类，那么他的子类也可以充当形参
	public void func(Animal animal) {
		animal.eat();
		animal.shout();
	}
}


class Animal {
	public void eat()	{
		System.out.println("吃");
	}
	public void shout() {
		System.out.println("叫");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("狗吃骨头");
	}
	public void shout() {
		System.out.println("汪汪汪");
	}
}

class Cat extends Animal{
	public void eat() {
		System.out.println("猫吃鱼");
	}
	public void shout() {
		System.out.println("喵喵喵");
	}
}