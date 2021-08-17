package Wrapper;

import org.junit.jupiter.api.Test;

public class InterviewTest {
	@Test
	public void test() {
		Integer i= new Integer(1);
		Integer j= new Integer(1);
		System.out.println(i==j);//false
		
		//Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
//		保存了从-128到127范围的整数，如果我们使用自动装箱的方式给Integer负值范围
//		在-128-127之间时，可以直接使用数组中的元素，不同再去new了。目的就是提高效率
		
		Integer m=1;//直接调用缓存中的数据
		Integer n=1;
		System.out.println(m==n);//true
		
		Integer x=128;//相当于new了一个对象
		Integer y=128;
		System.out.println(x==y);//false
	}
}
