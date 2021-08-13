package exercises;

/*
 * 对象数组题
 * 定义类Student，包含三个属性：学号number(int)，年纪state(int)，成绩score(int)
 * 创建20个学生对象，学号为1-20，年级和成绩都有随机数确定
 * 问题一：打印出3年级(state值为3)的学生信息
 * 问题二：是用冒泡排序法按学生成绩排序，并遍历所有学生信息
 */
public class StudentTest {
	public static void main(String[] args) {
		Student[] stus=new Student[20];//定义学生数组
		for(int i=0;i<stus.length;i++) {
			stus[i]=new Student();
			stus[i].score=(int)(Math.random()*101);
			stus[i].number=i+1;
			stus[i].state=(int)(Math.random()*6+1);
			stus[i].getStudentInfo();
		}
		System.out.println("----------------------------------");
		for(int i=0;i<stus.length;i++) {//输出三年级的学生信息
			if(stus[i].state==3) {
				stus[i].getStudentInfo();
			}
		}
		for(int i=0;i<stus.length-1;i++) {
			for(int j=0;j<stus.length-1-i;j++) {
				if(stus[j].score<stus[j+1].score) {
					int tmp=stus[j].score;
					stus[j].score=stus[j+1].score;
					stus[j+1].score=tmp;
				}
			}
		}
		System.out.println("-----------------------");
		for(int i=0;i<stus.length;i++) {
			stus[i].getStudentInfo();
		}
	}
}


class Student{
	int number;//学号
	int state;//年级
	int score;//成绩
	
	public void getStudentInfo() {
		System.out.println("学号："+number+"\t年级："+state+"\t成绩："+score);
	}
}


