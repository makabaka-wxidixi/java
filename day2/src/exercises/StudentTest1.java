package exercises;

/*
 * 对象数组题
 * 定义类Student，包含三个属性：学号number(int)，年纪state(int)，成绩score(int)
 * 创建20个学生对象，学号为1-20，年级和成绩都有随机数确定
 * 问题一：打印出3年级(state值为3)的学生信息
 * 问题二：是用冒泡排序法按学生成绩排序，并遍历所有学生信息
 * 
 * 
 *       优化代码：将操作数组的功能封装到方法中去
 */
public class StudentTest1 {
	public static void main(String[] args) {
		Student1[] stus=new Student1[20];//定义学生数组
		for(int i=0;i<stus.length;i++) {
			stus[i]=new Student1();
			stus[i].score=(int)(Math.random()*101);
			stus[i].number=i+1;
			stus[i].state=(int)(Math.random()*6+1);
			stus[i].getStudentInfo();
		}
		System.out.println("------------------------------");
		StudentTest1 test=new StudentTest1();
		test.printStateStudentInfo(stus, 3);
		System.out.println("------------------------------");
		test.sort(stus);
		test.printAllStudentInfo(stus);
	}
	
	
	public void printStateStudentInfo(Student1[] stus,int state) {//输出对应年级学生成绩
		for(int i=0;i<stus.length;i++) {
			if(stus[i].state==3) {
				stus[i].getStudentInfo();
			}
		}
	}
	
	public void sort(Student1[] stus) {//按成绩进行排序
		for(int i=0;i<stus.length-1;i++) {
			for(int j=0;j<stus.length-1-i;j++) {
				if(stus[j].score<stus[j+1].score) {
					int tmp=stus[j].score;
					stus[j].score=stus[j+1].score;
					stus[j+1].score=tmp;
				}
			}
		}
	}
	
	public void printAllStudentInfo(Student1[] stus) {//输出所有学生信息
		for(int i=0;i<stus.length;i++) {
			stus[i].getStudentInfo();
		}
	}

}

class Student1 {
	int number;//学号
	int state;//年级
	int score;//成绩
	
	public void getStudentInfo() {
		System.out.println("学号："+number+"\t年级："+state+"\t成绩："+score);
	}
}


