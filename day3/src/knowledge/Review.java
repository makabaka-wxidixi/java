package knowledge;

public class Review {
	public static void main(String[] args) {
		Student[] stus=new Student[5];
		System.out.println(stus[0]);//null
		stus[1]=new Student();
		System.out.println(stus[1]);//地址值
		System.out.println(stus[1].age);//0
	}
}


class Student{
	String name;
	int age;
	boolean isMale;
}