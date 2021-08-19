package day8_3;

public class ManTest {
	public static void main(String[] args) {
		Man man=new Man();
		man.help();
	}
}
interface Filial{
	default void help() {
		System.out.println("A");
	}
}


interface Spoony{
	default void help() {
		System.out.println("B");
	}
}

class Father{
	public void help() {
		System.out.println("C");
	}
}

class Man implements Filial,Spoony{
//	如何在子类（或者实现类）的方法中调用父类、接口中被重写的方法；
	public void help() {
		//调用接口中的默认方法
		Filial.super.help();
	}	
	
}

