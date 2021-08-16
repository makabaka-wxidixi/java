package polymorphism1;


/*
 * 多态是编译时行为还是运行时行为？
 * 证明如下
 */
public class InterviewTest {
	public static Animal getInstance(int key) {
		switch(key) {
		case 0:
			return new Dog();
		case 1:
			return new Cat();
		default:
			return new Sheep();
		}
	}
	
	public static void main(String[] args) {
		int key=(int)(Math.random()*3);
		System.out.println(key);
		Animal animal=getInstance(key);
		animal.eat();
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
}

class Cat extends Animal{
	public void eat() {
		System.out.println("猫吃鱼");
	}
}
	
class Sheep extends Animal{
	public void eat() {
		System.out.println("羊吃草");
	}
}