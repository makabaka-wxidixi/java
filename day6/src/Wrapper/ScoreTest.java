package Wrapper;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int maxScore=0;
		Vector v=new Vector();
		for(;;) {
			System.out.println("请输入学生的成绩，输入负数返回");
			int score=scan.nextInt();//输入数据
			if(score<0)	break;
			if(score>100) {
				System.out.println("输入成绩错误，请重新输入");
				continue;
			}
//			Integer inScore=new Integer(score);
//			v.addElement(inScore);//多态
			v.addElement(score);
			
			if(score>maxScore) {//替换最大值
				maxScore=score;
			}
		}
		char level;//等级
		for(int i=0;i<v.size();i++) {
			Object obj=v.elementAt(i); 
			Integer inScore=(Integer)obj;
			int score=inScore.intValue();
			
			if(maxScore-score<=10)	level='A';
			else if(maxScore-score<=20)	level='B';
			else if(maxScore-score<=30)	level='C';
			else if(maxScore-score<=40)	level='D';
			else level='E';
			
			System.out.println("student-"+i+"score is"+score+",level is"+level); 
		}
	}
}

